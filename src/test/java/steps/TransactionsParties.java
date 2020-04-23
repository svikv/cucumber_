package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.TransactionPartiesPage;
import utilities.DriverBuilder;

import java.util.List;
import java.util.Map;

public class TransactionsParties {

    private Logger LOG = Logger.getLogger(getClass());
    private WebDriver driver;
    private TransactionPartiesPage transactionParties;
    private General general;
    private int rawsBefore;
    private int rawsAfter;
    int rawsAfterDeleting;
    private String name;
    private String address;
    private String phone;
    private String newName;
    private String newAddress;
    private String newPhone;

    public TransactionsParties() {
        driver = DriverBuilder.driver;
        transactionParties = PageFactory.initElements(driver, TransactionPartiesPage.class);
        general = new General();
    }

    @When("^user switches to transaction Parties dictionary tab$")
    public void user_switches_to_transaction_parties_dictionary_tab() {
        transactionParties.tableView();
    }

    @And("^saves new record to dictionary$")
    public void saves_new_record_to_dictionary(DataTable arg) {
        rawsBefore = transactionParties.countTableRows();
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        name = table.get(0).get("Name");
        address = table.get(0).get("Address");
        phone = table.get(0).get("Phone");
        transactionParties.addTableRecord(name, address, phone);
    }

    @And("^fills in the following fields$")
    public void fills_in_the_following_fields(DataTable arg) {
        rawsBefore = transactionParties.countTableRows();
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        name = table.get(0).get("Name");
        address = table.get(0).get("Address");
        phone = table.get(0).get("Phone");
        transactionParties.fillTableFields(name, address, phone);
    }

    @And("^clicks on Create button$")
    public void clicks_on_create_button() {
        transactionParties.createTableRecord();
    }








    @Then("^user should see the record in dictionary$")
    public void user_should_see_the_record_in_dictionary() {
        rawsAfter = transactionParties.countTableRows();
        Assert.assertEquals(rawsBefore + 1, rawsAfter);

        String actualRecord = transactionParties.getTableRecord(rawsAfter - 1);
        String expectedRecord = name + " " + address + " " + phone;
        Assert.assertTrue("Table record wasn't updated", actualRecord.contains(expectedRecord));
    }

    @And("^user deletes new record from dictionary$")
    public void user_deletes_new_record_from_dictionary() {
        transactionParties.deleteTableRecord(rawsAfter);
        rawsAfterDeleting = transactionParties.countTableRows();
    }

    @Then("^user should not see the record in dictionary$")
    public void user_should_not_see_the_record_in_dictionary() {
        Assert.assertEquals("Record wasn't deleted from table", rawsAfter - 1, rawsAfterDeleting);
    }

    @And("^user updates new record from dictionary with values$")
    public void user_updates_new_record_from_dictionary_with_values(DataTable arg) {
        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        newName = table.get(0).get("Name");
        newAddress = table.get(0).get("Address");
        newPhone = table.get(0).get("Phone");
        transactionParties.updateTableRecord(rawsAfter, newName, newAddress, newPhone);
    }

    @Then("^user should see the updated record in dictionary$")
    public void user_should_see_the_updated_record_in_dictionary() {
        String actualRecord = transactionParties.getTableRecord(rawsAfter - 1);
        String expectedRecord = newName + " " + newAddress + " " + newPhone;
        Assert.assertTrue("Table record wasn't updated", actualRecord.contains(expectedRecord));
    }

}