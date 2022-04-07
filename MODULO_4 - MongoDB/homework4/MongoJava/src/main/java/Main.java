import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("tindev");

        MongoCollection<Document> userTindev = mongoDatabase.getCollection("tindev_user");
        MongoCollection<Document> salarios = mongoDatabase.getCollection("salario");

        Document userJoao = new Document("nome", "joao")
                .append("progLang", "JAVA")
                .append("gender", "MALE")
                .append("pref", "WOMEN")
                .append("address", new Document("street", "rua joao")
                        .append("city", "cachoerinha"))
                .append("personinfo", new Document("email", "joao@mail.com")
                        .append("age", 22));


        Document userRafael = new Document("nome", "rafael")
                .append("progLang", "JAVA")
                .append("gender", "MALE")
                .append("pref", "WOMEN")
                .append("address", new Document("street", "rua 7")
                        .append("city", "cachoerinha"))
                .append("personinfo", new Document("email", "luiz@mail.com")
                        .append("age", 24));

        Document userAna = new Document("nome", "ana")
                .append("progLang", "PHP")
                .append("gender", "FEMALE")
                .append("pref", "BOTH")
                .append("address", new Document("street", "rua ana")
                        .append("city", "cachoerinha"))
                .append("personinfo", new Document("email", "ana@mail.com")
                        .append("age", 18));

        Document userJuliana = new Document("nome", "juliana")
                .append("progLang", "JAVA")
                .append("gender", "FEMALE")
                .append("pref", "MAN")
                .append("address", new Document("street", "rua juliana")
                        .append("city", "cachoerinha"))
                .append("personinfo", new Document("email", "juliana@mail.com")
                        .append("age", 28));

        Document userCarlos = new Document("nome", "carlos")
                .append("progLang", "JAVA")
                .append("gender", "MALE")
                .append("pref", "BOTH")
                .append("address", new Document("street", "rua carlos")
                        .append("city", "cachoerinha"))
                .append("personinfo", new Document("email", "carlos@mail.com")
                        .append("age", 26));

        // INSERIR USUÁRIOS
//        userTindev.insertMany(asList(userAna, userRafael, userJuliana, userCarlos));

        //INSERIR UM USUÁRIO
//        userTindev.insertOne(userJoao);

        //FIND USUARIO POR IDADE
//        userTindev.find(new Document("personinfo.age" , 26)).forEach(doc -> System.out.println(doc.toJson()));

        //FIND ALL
//        userTindev.find().forEach(System.out::println);

        //FIND POR NOME
//        userTindev.find(new Document("nome" , "carlos")).forEach(doc -> System.out.println(doc.toJson()));

        //FIND POR NOME REGEX
//        userTindev.find(Filters.regex("nome", "ju")).forEach(doc -> System.out.println(doc.toJson()));

        //UPDATE
//        userTindev.updateOne(Filters.eq("nome", "juliana"), new Document("$set", new Document("nome" , "julia")));

        //UPDATE
//        userTindev.updateOne(Filters.lt("personinfo.age", 26),new Document("$set", new Document("progLang" , "C++")));

        //DELETE ALL
//        DeleteResult deleteMany = userTindev.deleteMany(new Document());

        //DELETAR FILTER
//        userTindev.deleteOne(Filters.eq("personinfo.age", 18));

        //AGGREGATE SALARIO
//        salarios.aggregate(Arrays.asList(
//                match(Filters.eq("status", "estagiario")),
//                group("$empresa", Accumulators.sum("total", "$salario"))))
//                .forEach(doc -> System.out.println(doc.toJson()));


        mongoClient.close();
    }
}
