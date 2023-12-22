package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.request.*;
import models.response.*;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    @Step ("Получение user по имени")
    public UserResponse getUserByName(String userName) {
        return given()
                .log().all()
                .get("https://petstore.swagger.io/v2/user/" + userName)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response().as(UserResponse.class);
    }
    @Step ("Создание user")
    public StannayaResponse postCreateUser(UserRequest UR) {
        return given()
                .log().all()
                .body(UR)
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200)
                .extract()
                .response().as(StannayaResponse.class);
    }
    @Step ("Изменение user")
    public StannayaResponse putUpdateUser(String userName, UserRequest UR) {
        return given()
                .log().all()
                .body(UR)
                .contentType(ContentType.JSON)
                .put("https://petstore.swagger.io/v2/user/" + userName)
                .then()
                .statusCode(200)
                .extract()
                .response().as(StannayaResponse.class);
    }
    @Step ("Удаление user")
    public void deleteUser(String userName) {
        given()
                .log().all()
                .delete("https://petstore.swagger.io/v2/user/" + userName)
                .then()
                .statusCode(200)
                .extract();
    }
    @Step ("Авторизация")
    public StannayaResponse getLoginUser(String userName, String password) {
        return given()
                .log().all()
                .get("https://petstore.swagger.io/v2/user/login?username=" + userName +"&password=" + password)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response().as(StannayaResponse.class);
    }
    @Step ("Вход из системы")
    public StannayaResponse getLogout() {
        return given()
                .log().all()
                .get("https://petstore.swagger.io/v2/user/logout")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response().as(StannayaResponse.class);
    }
}