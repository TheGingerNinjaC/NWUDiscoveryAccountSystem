package za.ac.nw.discovery.web.controller;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nw.discovery.domain.dto.AccountDto;
import za.ac.nw.discovery.domain.persistence.Account;
import za.ac.nw.discovery.domain.service.GeneralResponse;
import za.ac.nw.discovery.logic.flow.IAccountFlow;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {

    private final IAccountFlow accountFlow;

    public AccountController(IAccountFlow accountFlow){
        this.accountFlow = accountFlow;
    }

    @GetMapping("{accountId}")
    @ApiOperation(value = "Fetches the account related to the specified account id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountDto>> getAccount(
            @ApiParam(value = "The account id.",
            example = "1",
            name = "accountId",
            required = true)
            @PathVariable("accountId") final Long accountId){
        AccountDto account = accountFlow.getAccount(accountId);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Creates a new Account", notes = "Creates a new Account in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Account was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountDto>> createAccount(
            @ApiParam(value = "Request body to create new account", required = true)
            @RequestBody AccountDto account){
        AccountDto accountDto = accountFlow.createAccount(account);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, accountDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
