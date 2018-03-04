package students.client;

import java.util.Date;

/**
 * Created by ilyaP on 28.02.2018.
 */
public class Student {
    private static int idBuilder = 0;
    private String name;
    private int idOfUniversity;
    private Date dateCreate;
    private Date dateChange;
    private boolean isExist;


    public Student(String name) {
        this.name = name;
        dateCreate = new Date();
        dateChange = dateCreate;
        idOfUniversity = idBuilder++;
        isExist = true;
    }

    public Date getDateChange() {
        return dateChange;
    }

    public long getIdOfUniversity() {
        return idOfUniversity;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
        dateChange = new Date();
    }


    public boolean isExist() {
        return isExist;
    }
}
