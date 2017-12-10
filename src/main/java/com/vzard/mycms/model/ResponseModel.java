package com.vzard.mycms.model;


import com.vzard.mycms.database.tables.pojos.Student;
import io.swagger.models.Response;
import io.swagger.models.auth.In;

public class ResponseModel<T> {

    private Integer code;
    private String message;
    private T data;

    public static class ResponseModelBuilder<T>{
        private Integer code;
        private String message;
        private T data;

        public ResponseModelBuilder code(Integer code){
            this.code = code;
            return this;
        }

        public ResponseModelBuilder message(String message){
            this.message = message;
            return this;
        }

        public ResponseModelBuilder data(T data){
            this.data = data;
            return this;
        }

        public ResponseModel build(){
            return new ResponseModel(this);
        }


    }


    public ResponseModel(){};

    public ResponseModel(ResponseModelBuilder<T> builder){
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;

    }
    public static ResponseModelBuilder builder(){
        return new ResponseModelBuilder();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString(){

        return "ReponseModel{ \n"+
                "code: "+code+",\n"
                +"message: "+message+",\n"
                +"data: "+data+"\n"
                +"}";

    }

    //test and use example
    public static void main(String[] args) {

        ResponseModel model = ResponseModel.builder().code(200).message("message").data(new Student()).build();
        System.out.println(model);

    }



}
