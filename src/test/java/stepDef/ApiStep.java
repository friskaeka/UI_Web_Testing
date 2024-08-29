package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep(){
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit api get list user")
    public void hitApiGetListUser() {
        apiPage.hitApiGetListUser();
    }

    @Then("validation status code is equal {int}")
    public void validationStatusCodeIsEqual(int status_code) {
        apiPage.validationStatusCodeIsEqual(status_code);
    }

    @Then("validation response body get list user")
    public void validationResponseBodyGetListUser() {
        apiPage.validationResponseBodyGetListUser();
    }

    @Then("validation response json with JSONschema {string}")
    public void validationResponseJsonWithJSONschema(String filename) {
        apiPage.validationResponseJsonWithJSONschema(filename);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateNewUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyPostCreateNewUser();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @And("hit api update user")
    public void hitApiUpdateUser() {
        apiPage.hitApiUpdateUser();
    }

    @Then("Validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }
}
