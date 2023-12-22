import models.request.*;
import steps.*;
import models.response.*;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    @Test(description = "Пользователь получает user по имени", priority = 2)
    public void getUserByName() {
        UserResponse userName = API_STEPS.getUserByName("Oleja");
        System.out.println("Test 1: " + userName + "\n");
    }
    @Test (description = "Пользователь создаёт нового user", priority = 1)
    public void postCreateUser() {
        UserRequest user = new UserRequest(1, "Oleja", "Oleg",
                "olegov", "oleg@mail.ru", "1234", "88005553535", 1);
        StannayaResponse str = API_STEPS.postCreateUser(user);
        System.out.println("Test 2: " + str + "\n");
    }
    @Test (description = "Пользователь изменяет существующего user", priority = 4)
    public void putUpdateUser() {
        UserRequest user = new UserRequest(1, "Oleja2",
                "Oleg2", "olegov2", "oleg@mail.ru",
                "1234", "88005553535", 1);
        StannayaResponse str = API_STEPS.putUpdateUser("Oleja", user);
        System.out.println("Test 3: " + str + "\n");
    }
    @Test (description = "Пользователь удаляет существующего user", priority = 5)
    public void deleteUser() {
        API_STEPS.deleteUser("Oleja2");
        System.out.println("Test 4: User Oleja2 deleted" + "\n");
    }
    @Test (description = "Пользователь авторизуется под своим логином и паролем", priority = 3)
    public void getLoginUser() {
        StannayaResponse str = API_STEPS.getLoginUser("Oleja", "1234");
        System.out.println("Test 5: " + str + "\n");
    }
    @Test (description = "Пользователь выходит из системы", priority = 6)
    public void getLogout() {
        StannayaResponse str = API_STEPS.getLogout();
        System.out.println("Test 6: User logout " + str);
    }
}