package smartyflip_testng.pages;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviderClass {
    private Object[][] readDataFromCSV(String fileName) {
        String filePath = "./src/test/resources/csv_files_for_dataProviders/" + fileName;
        List<Object[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return data.toArray(new Object[data.size()][]);
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return readDataFromCSV("email_password_invalid.csv");
    }

    @DataProvider(name = "invalidNameData")
    public Object[][] getInvalidTextNameData() {
        return readDataFromCSV("name_invalid.csv");
    }

    @DataProvider(name = "invalidLoginRegistrData")
    public Object[][] getInvalidLoginRegistrData() {
        return readDataFromCSV("login_invalid.csv");
    }//??


    @DataProvider(name = "invalidEMailData")
    public Object[][] getInvalidEmailData() {
        return readDataFromCSV("email_invalid.csv");
    }

    @DataProvider(name = "emptyFieldEMailData")
    public Object[][] getEmptyEmailData() {
        return readDataFromCSV("email_empty.csv");
    }


    @DataProvider(name = "invalidPasswordData")
    public Object[][] getInvalidPassword() {
        return readDataFromCSV("password_invalid.csv");
    }

    @DataProvider(name = "registeredUserValidData")
    public Object[][] getRegisteredUserValidData() {
        return readDataFromCSV("login_exist_password_valid.csv");
    }

    @DataProvider(name = "validNotRegisteredLoginValidPasswordData")
    public Object[][] getValidNotRegisteredLoginValidPasswordData() {
        return readDataFromCSV("login_valid_password_valid.csv");
    }


    @DataProvider(name = "invalidLoginValidPasswordData")
    public Object[][] getInvalidLoginValidPasswordData() {
        return readDataFromCSV("login_invalid_password_valid.csv");
    }

    @DataProvider(name = "invalidLoginValidEmailData")
    public Object[][] getInvalidLoginValidEmailData() {
        return readDataFromCSV("login_invalid_email_valid.csv");
    }

    @DataProvider(name = "validLoginInvalidEmailData")
    public Object[][] getValidLoginInvalidEmailData() {
        return readDataFromCSV("login_valid_email_invalid.csv");
    }

    @DataProvider(name = "existLoginInvalidPasswordData")
    public Object[][] getValidLoginInvalidPasswordData() {
        return readDataFromCSV("login_exist_password_invalid.csv");
    }

    @DataProvider(name = "validNewUserRegisterWithDataProvider")
    public Object[][] getValidNewUserRegisterData() {
        return readDataFromCSV("register_new_user_serhii_valid.csv");
    }
}