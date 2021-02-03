public class CustomerAnalyzer {
    public void searchByLastName(String key, Customer[] customerList){
        System.out.format("%s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s", "Customer ID", "First Name", "Last Name", "Country Code", "Mobile Number", "Flat No.", "Street", "Taluk", "City", "State", "Country", "Pincode");
        System.out.println();
        for(int i=0;i<customerList.length;i++){
            if(key.equals(customerList[i].getLastName())){
                System.out.format("%d %20s %20s %20s %20d %20s %20s %20s %20s %20s %20s %20d", customerList[i].getCustID(), customerList[i].getfirstName(), customerList[i].getLastName(), customerList[i].getcountryCode(), customerList[i].getMobileNumber(), customerList[i].getFlatNo(), customerList[i].getStreetName(), customerList[i].getTalukName(), customerList[i].getCityName(), customerList[i].getStateName(), customerList[i].getCountry(), customerList[i].getPinCode());
                System.out.println();
            }
        }
    }

    public void searchByVillageName(String key, Customer[] customerList){
        System.out.format("%s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s", "Customer ID", "First Name", "Last Name", "Country Code", "Mobile Number", "Flat No.", "Street", "Taluk", "City", "State", "Country", "Pincode");
        System.out.println();
        for(int i=0;i<customerList.length;i++){
            if(key.equals(customerList[i].getCityName())){
                System.out.format("%d %20s %20s %20s %20d %20s %20s %20s %20s %20s %20s %20d", customerList[i].getCustID(), customerList[i].getfirstName(), customerList[i].getLastName(), customerList[i].getcountryCode(), customerList[i].getMobileNumber(), customerList[i].getFlatNo(), customerList[i].getStreetName(), customerList[i].getTalukName(), customerList[i].getCityName(), customerList[i].getStateName(), customerList[i].getCountry(), customerList[i].getPinCode());
                System.out.println();
            }
        }
    }
}
