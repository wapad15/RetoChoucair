package co.com.orange.reto.models;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class EmployeeData {
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String password;

    public static List<EmployeeData> fromDataTable(DataTable dataTable) {
        List<EmployeeData> employeeList = new ArrayList<>();
        List<Map<String, String>> dataMaps = dataTable.asMaps();
        for (Map<String, String> map : dataMaps) {
            employeeList.add(new ObjectMapper().convertValue(map, EmployeeData.class));
        }
        return employeeList;
    }
}
