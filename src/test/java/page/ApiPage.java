package page;
//perhitungan data dilakukan disini


import helper.Endpoint;
import helper.utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setUrl, global_id;
    Response res;

    public void prepareUrlFor(String url){
        switch (url){
            case "GET_LIST_USER":
                setUrl = Endpoint.GET_LIST_USER;
                break;
            case "CREATE_NEW_USER":
                setUrl = Endpoint.CREATE_NEW_USER;
                break;
            case "DELETE_USER":
                setUrl = Endpoint.DELETE_USER;
                break;
            default:
                System.out.println("input url yang benar");
        }
    }

    public void hitApiGetListUser(){
        res = getListUser(setUrl);
    }

    public void hitApiPostCreateNewUser(){
        res = postCreateUser(setUrl);
    }

    public void hitApiDeleteUser(){
        res = deleteuser(setUrl, global_id);
    }

    public void hitApiUpdateUser(){
        res = updateuser(setUrl, global_id);
    }

    public void validationResponseBodyUpdateUser() {
        System.out.println(res.getBody().asString());

        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.getString("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active","inactive");
    }

    public void validationStatusCodeIsEqual(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
        System.out.println("status code " + status_code);
    }

    public void validationResponseBodyGetListUser(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");

    }

    public void validationResponseBodyPostCreateNewUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.getString("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active","inactive");

        global_id = Integer.toString(id);
    }

    public void validationResponseJsonWithJSONschema(String filename){
        File JSONFile = utility.getJsonSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }



}

