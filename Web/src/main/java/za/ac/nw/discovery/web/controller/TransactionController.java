package za.ac.nw.discovery.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nw.discovery.domain.dto.TransactionDto;
import za.ac.nw.discovery.domain.service.GeneralResponse;
import za.ac.nw.discovery.logic.flow.IFetchTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final IFetchTransactionFlow fetchTransactionFlow;

    public TransactionController(IFetchTransactionFlow fetchTransactionFlow) {
        this.fetchTransactionFlow = fetchTransactionFlow;
    }

    @GetMapping("/allMiles")
    @ApiOperation(value = "Gets all the Discovery Miles transactions.", notes = "Return a list of transactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<TransactionDto>>> getAllMiles(){
        List<TransactionDto> transactions = fetchTransactionFlow.getAllMilesTransactions();
        GeneralResponse<List<TransactionDto>> response = new GeneralResponse<>(true, transactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a new Transaction", notes = "Creates a new Transaction in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Account was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<TransactionDto>> createTransaction(
            @ApiParam(value = "Request body to create transaction.", required = true)
            @RequestBody TransactionDto transaction) {
        TransactionDto transactionDto = fetchTransactionFlow.createTransaction(transaction);
        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
