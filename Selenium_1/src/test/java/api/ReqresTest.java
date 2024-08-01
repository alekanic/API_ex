package api;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarpicocli.CommandLine;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;



import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private final static String URL = "https://reqres.in/";

    /*
    1 - Используя сервис https://reqres.in/ получить список пользователей со второй (2) страницы
    2- Убедиться, что имена файлов-аватаров пользователей совпадают
    3 - Убедиться, что email пользователей имеет окончание reqres.in
    */
    @JsonCreator
    @JsonProperty
    @Test
    public void checkAvatarAndIdTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                //.contentType(ContentType.JSON) // какой ожидаем тип возвращаемый данных
                //.get(URL+"api/users?page=2")// http-запрос
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class); // сохранить все в виде списка, извлекаем в класс UserData
        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString()))); // выбираем нужный элемент из списка

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            avatars.get(i).contains(ids.get(i));
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }
}
