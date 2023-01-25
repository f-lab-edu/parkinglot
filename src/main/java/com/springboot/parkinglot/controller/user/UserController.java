package com.springboot.parkinglot.controller.user;

import com.springboot.parkinglot.common.CustomException;
import com.springboot.parkinglot.controller.CheckValidity;
import com.springboot.parkinglot.service.user.UserService;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
@RequestMapping("/user")
public class UserController implements CheckValidity {

    private  final UserService userService;

    private final static Logger logger= Logger.getGlobal();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> createUserRequest(@RequestBody UserDto userDto){

        //checkValidity
        checkString(userDto.getId());
        checkString(userDto.getPassword());
        checkString(userDto.getName());

        //new checkValidity methode
        check(userDto.getName());

        UserResponseDto userResponseDto = userService.saveUser(userDto);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @GetMapping()
    public  ResponseEntity<UserResponseDto> getUserRequest(Long number){
        UserResponseDto userResponseDto = userService.getUser(number);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PutMapping()
    public ResponseEntity<UserResponseDto> changeUser
            (@RequestBody ChangeUserNameDto changeUserNameDto) throws Exception {

        //checkValidity
        checkString(changeUserNameDto.getId());
        checkString(changeUserNameDto.getPassword());
        checkLong(changeUserNameDto.getNumber());

        UserResponseDto userResponseDto = userService.chageUserName(
                changeUserNameDto.getNumber(), changeUserNameDto.getId(),
                changeUserNameDto.getPassword()
        );
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping()
    public  ResponseEntity<String> deleteUser(Long number) throws Exception{
        userService.deleteUser(number);

        return  ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }


    @Override
    public void checkString(String value) {

        if(value==null){
            logger.info("null");
        }
        if(value!=null && value.length()>20){
            logger.info("size is more than 20");
        }
        if(value.isBlank()){
            logger.info("isBlank");
        }

    }

    @Override
    public void checkLong(Long value) {
        if(value==null){
            logger.info("null");
        }
        if(value!=null && Long.toString(value).length()>20){
            logger.info("size is more than 20");
        }
        if(Long.toString(value).isBlank()){
            logger.info("isBlank");
        }
    }

    @Override   //how to make diverse input and same name?
    public void check(String name) {
        if(name.length() <10){
            throw new CustomException();
        }
    }

    @Component  //location is correct?
    class ExceptionHandlers{
        @ExceptionHandler(CustomException.class)
        public ErrorMessage exception(CustomException e){
            e.printStackTrace();

            ErrorMessage message = new ErrorMessage();
            message.setMessage("too short name");
            message.setCode(999);
            return message;
        }
    }

    @Data
    class ErrorMessage{
        private String message;
        private int code;
    }
}
