package za.ac.nw.discovery.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nw.discovery.domain.dto.AccountTransactionDto;
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
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAllMiles(){
        List<AccountTransactionDto> transactions = fetchTransactionFlow.getAllMilesTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, transactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a new Transaction", notes = "Creates a new Transaction in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Account was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> createTransaction(
            @ApiParam(value = "Request body to create transaction.", required = true)
            @RequestBody AccountTransactionDto transaction) {
        AccountTransactionDto transactionDto = fetchTransactionFlow.createTransaction(transaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/addMiles")
    @ApiOperation(value = "Adds Miles.", notes = "Adds a transaction and updates the account balance")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Miles successfully added", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> addMiles(
            @ApiParam(value = "Request body to add Miles.", required = true)
            @RequestBody AccountTransactionDto transaction) {
        AccountTransactionDto transactionDto = fetchTransactionFlow.addMiles(transaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/subtractMiles")
    @ApiOperation(value = "Subtracts Miles.", notes = "Adds a transaction and updates the account balance")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Miles successfully subtracted", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> subtractMiles(
            @ApiParam(value = "Request body to subtract Miles.", required = true)
            @RequestBody AccountTransactionDto transaction) {
        AccountTransactionDto transactionDto = fetchTransactionFlow.subtractMiles(transaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, transactionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
