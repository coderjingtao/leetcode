package solutions.amazon.spring2023;

import java.util.*;

/**
 * 2408 Design SQL
 * Keywords: oop, design
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2408DesignSQL {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("one", "two", "three");
        List<Integer> columns = Arrays.asList(2, 3, 1);
        SQL sql = new SQL(names,columns);

        String name = "two";
        List<String> row = Arrays.asList("first", "second", "third");
        sql.insertRow(name,row);

        String val = sql.selectCell(name, 1, 3);
        System.out.println("val = " + val);

        List<String> newRow = Arrays.asList("fourth", "fifth", "sixth");
        sql.insertRow(name,newRow);

        sql.deleteRow(name,1);
        String val2 = sql.selectCell(name, 2, 2);
        System.out.println("val2 = " + val2);
    }
}

class SQL {

    private Map<String,List<List<String>>> tables;

    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>(names.size());
        for(int i = 0; i < names.size(); i++){
            String name = names.get(i);
            List<List<String>> table = new ArrayList<>();
            tables.put(name,table);
        }
    }

    public void insertRow(String name, List<String> row) {
        List<List<String>> table = tables.get(name);
        table.add(row);
    }

    public void deleteRow(String name, int rowId) {
        List<List<String>> table = tables.get(name);
        table.remove(rowId -1);
        table .add(rowId-1, new ArrayList<>());
    }

    public String selectCell(String name, int rowId, int columnId) {
        List<List<String>> table = tables.get(name);
        List<String> row = table.get(rowId-1);
        if(row.size() >= columnId){
            return row.get(columnId-1);
        }
        return null;
    }
}