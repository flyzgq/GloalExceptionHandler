package com.hackerrank.restcontrolleradvice.controller;

import com.hackerrank.restcontrolleradvice.dto.*;
import com.hackerrank.restcontrolleradvice.enums.FizzBuzzEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "全局异常处理相关接口")
@RestController
public class FizzBuzzController {
  /**
   * GET /controller_advice/fizz:
   *
   * Response Code: 500
   *
   * Response Body:
   *
   * {
   *     "message": "Fizz Exception has been thrown",
   *     "errorReason" : "Internal Server Error"
   * }
   * GET /controller_advice/buzz:
   *
   * Response Code: 400
   *
   * Response Body:
   *
   * {
   *     "message": "Buzz Exception has been thrown",
   *     "errorReason" : "Bad Request"
   * }
   * GET /controller_advice/fizzbuzz:
   *
   * Response Code: 507
   *
   * Response Body:
   *
   * {
   *     "message": "FizzBuzz Exception has been thrown",
   *     "errorReason" : "Insufficient Storage"
   * }
   * GET /controller_advice/success:
   *
   * Response Code: 200
   *
   * Response Body:
   *
   * {
   *     "message": "Successfully completed fizzbuzz test",
   *     "statusCode": "200"
   * }
   * @param code
   * @return
   * @throws FizzException
   * @throws BuzzException
   * @throws FizzBuzzException
   */

  @ApiOperation(value = "异常请求")
  @RequestMapping(value = "/controller_advice/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FizzBuzzResponse> getFizzBuzzResponse(@PathVariable("code") String code)
          throws FizzException, BuzzException, FizzBuzzException {
    ResponseEntity<FizzBuzzResponse> responseEntity ;
    if (FizzBuzzEnum.FIZZ.getValue().equals(code)) {
      //throw new FizzException
       throw  new FizzException("Fizz Exception has been thrown","Internal Server Error");

    } else if (FizzBuzzEnum.BUZZ.getValue().equals(code)) {

      throw new BuzzException("Buzz Exception has been thrown", "Bad Request");


    } else if (FizzBuzzEnum.FIZZBUZZ.getValue().equals(code)) {
      //throw new FizzBuzzException
      throw  new FizzBuzzException("FizzBuzz Exception has been thrown","Insufficient Storage");

    }
    FizzBuzzResponse fizzBuzzResponse = new FizzBuzzResponse("Successfully completed fizzbuzz test",200);
    responseEntity = new ResponseEntity<FizzBuzzResponse>(fizzBuzzResponse, HttpStatus.OK);
    return responseEntity;
  }
}
