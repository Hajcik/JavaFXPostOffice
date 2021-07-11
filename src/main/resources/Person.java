package main.resources;

public class Person {

    private String Id;
    private String Name;
    private String Surname;
    public boolean hasCompany;
    private String CompanyName;
    private String Address;
    private String HouseNumber;
    private String PostalAddress;
    private String City;

    public Person() {
    }

    public Person(String id, String name, String surname, boolean hasCompany, String companyName, String address, String houseNumber, String postalAddress, String city) {
        Id = id;
        Name = name;
        Surname = surname;
        this.hasCompany = hasCompany;
        CompanyName = companyName;
        Address = address;
        HouseNumber = houseNumber;
        PostalAddress = postalAddress;
        City = city;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public boolean isHasCompany() {
        return hasCompany;
    }

    public void setHasCompany(boolean hasCompany) {
        this.hasCompany = hasCompany;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getPostalAddress() {
        return PostalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        PostalAddress = postalAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "{" +
                "\"Id\":\"" + Id + '\"' +
                ",\"Name\":\"" + Name + '\"' +
                ",\"Surname\":\"" + Surname + '\"' +
                ",\"hasCompany\":" + hasCompany +
                ",\"CompanyName\":\"" + CompanyName + '\"' +
                ",\"Address\":\"" + Address + '\"' +
                ",\"HouseNumber\":\"" + HouseNumber + '\"' +
                ",\"PostalAddress\":\"" + PostalAddress + '\"' +
                ",\"City\":\"" + City + '\"' +
                '}';
    }

    public String listViewDisplay()
    {
        if(!hasCompany){
            return  "ID: " + Id  +
                    " \nName: " + Name +
                    " \nSurname: " + Surname +
                    " \nAddress: " + Address + " " + HouseNumber +
                    " \nCity and Postal: " + City + " " + PostalAddress;
        }
        else return "ID: " + Id  +
                    " \nName: " + Name +
                    " \nSurname: " + Surname +
                    " \nAddress: " + Address + " " + HouseNumber +
                    " \nCity and Postal: " + City + " " + PostalAddress +
                    " \nCompany: " + CompanyName;
    }

}
