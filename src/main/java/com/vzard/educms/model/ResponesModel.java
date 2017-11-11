package com.vzard.educms.model;


import com.vzard.educms.database.tables.Student;

/**
 * Created with IntelliJ IDEA.
 * User: vzard
 * Date: 2017/11/11
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 * Description:
 **/

public class ResponesModel<T> {

    private Integer code;
    private String message;
    private T data;

    //内部类
    public static class ResponesModelBuilder<T>{

        private Integer code;
        private String message;
        private T data;

        public ResponesModelBuilder code(Integer code){
            this.code = code;
            return this;
        }

        public ResponesModelBuilder message(String message){
            this.message = message;
            return this;
        }

        public ResponesModelBuilder data(T data){
            this.data = data;
            return this;
        }

        public ResponesModel build(){
            return new ResponesModel(this);
        }


    }


    //构造函数(无参)序列化需要
    public ResponesModel(){}

    public ResponesModel(ResponesModelBuilder<T> builder){

        this.code = builder.code;
        this.data = builder.data;
        this.message = builder.message;
    }


    public static ResponesModelBuilder builder(){

        return new ResponesModelBuilder();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

        ResponesModel model = ResponesModel.builder().code(200).message("message").data(new Student()).build();
        System.out.println(model);

    }








}
