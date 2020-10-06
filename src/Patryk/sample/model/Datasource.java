package Patryk.sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Datasource {

    public static final String DB_NAME = "data.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Programowanie\\PODYPLOMÓWKA\\Bazy danych\\Zjazd\\" + DB_NAME;

    public static final String TABLE_PERSONS = "persons";
    public static final String COLUMN_PERSON_ID = "PersonID";
    public static final String COLUMN_PERSON_NAME = "name";
    public static final String COLUMN_PERSON_SURNAME = "surname";
    public static final String COLUMN_PERSON_TITLE = "AcademicTitle";
    public static final String COLUMN_PERSON_ACADEMY= "AcademyID";
    public static final String COLUMN_PERSON_DEPARTMENT = "DepartmentID";
    public static final String COLUMN_PERSON_PHONE_NUMBER = "PhoneNumber";
    public static final String COLUMN_PERSON_EMAIL = "EmailAdress";
    public static final String COLUMN_PERSON_DINNER = "NumberOfDinner";
    public static final String COLUMN_PERSON_ROOM = "NumberOfNights";
    public static final int INDEX_PERSON_ID = 1;
    public static final int INDEX_PERSON_NAME = 2;
    public static final int INDEX_PERSON_SURNAME = 3;
    public static final int INDEX_PERSON_TITLE = 4;
    public static final int INDEX_PERSON_ACADEMY = 5;
    public static final int INDEX_PERSON_DEPARTMENT = 6;
    public static final int INDEX_PERSON_PHONE_NUMBER = 7;
    public static final int INDEX_PERSON_EMAIL = 8;
    public static final int INDEX_PERSON_DINNER = 9;
    public static final int INDEX_PERSON_ROOM = 10;

    public static final String TABLE_ACADEMY = "Academy";
    public static final String COLUMN_ACADEMY_ID = "AcademyID";
    public static final String COLUMN_ACADEMY_NAME = "AcademyName";
    public static final String COLUMN_ACADEMY_ADDRESS = "AdressID";
    public static final int INDEX_ACADEMY_ID = 1;
    public static final int INDEX_ACADEMY_NAME = 2;
    public static final int INDEX_ACADEMY_ADDRESS = 3;

    public static final String TABLE_DEPARTMENT = "Department";
    public static final String COLUMN_DEPARTMENT_ID = "DepartmentID";
    public static final String COLUMN_DEPARTMENT_NAME = "DepartmentName";
    public static final int INDEX_DEPARTMENT_ID = 1;
    public static final int INDEX_DEPARTMENT_NAME = 2;

    public static final String TABLE_ADDRESS = "Adress";
    public static final String COLUMN_ADDRESS_ID = "AdressID";
    public static final String COLUMN_ADDRESS_CITY = "City";
    public static final String COLUMN_ADDRESS_POSTCODE = "PostCod";
    public static final String COLUMN_ADDRESS_COUNTRY = "Country";
    public static final int INDEX_ADDRESS_ID = 1;
    public static final int INDEX_ADDRESS_CITY = 2;
    public static final int INDEX_ADDRESS_POSTCODE = 3;
    public static final int INDEX_ADDRESS_COUNTRY = 4;


    public static final String TABLE_LECTURES = "Lectures";
    public static final String COLUMN_LECTURES_ID = "LecturesID";
    public static final String COLUMN_LECTURES_NAME = "NameOfLec";
    public static final String COLUMN_LECTURES_PERSON = "PersonID";
    public static final String COLUMN_LECTURES_SUMMARY = "Summary";
    public static final String COLUMN_LECTURES_DATE_OF_REFER = "DateOfRefer";
    public static final int INDEX_LECTURES_ID = 1;
    public static final int INDEX_LECTURES_NAME = 2;
    public static final int INDEX_LECTURES_PERSON = 3;
    public static final int INDEX_LECTURES_SUMMARY = 4;
    public static final int INDEX_LECTURES_DATE_OF_REFER = 4;

    public static final String TABLE_DINNER = "Dinner";
    public static final String COLUMN_DINNER_ID = "DinnerID";
    public static final String COLUMN_DINNER_PERSON_ID = "PersonID";
    public static final String COLUMN_DINNER_DATE_OF_RESERVATION = "DateOfReservation";
    public static final int INDEX_DINNER_ID = 1;
    public static final int INDEX_DINNER_PERSON_ID = 2;
    public static final int INDEX_DINNER_DATE_OF_RESERVATION = 3;

    public static final String TABLE_ROOM1 = "Rooms1";
    public static final String COLUMN_ROOM1_ID = "RoomID";
    public static final String COLUMN_ROOM1_PERSON = "PersonID";
    public static final String COLUMN_ROOM1_DATE_OF_RESERVATION = "DateOfReservation";
    public static final int INDEX_ROOM1_ID = 1;
    public static final int INDEX_ROOM1_PERSON = 2;
    public static final int INDEX_ROOM1_DATE_OF_RESERVATION = 3;

    public static final String TABLE_ROOM2 = "Rooms2";
    public static final String COLUMN_ROOM2_ID = "RoomID";
    public static final String COLUMN_ROOM2_PERSON1 = "Person1ID";
    public static final String COLUMN_ROOM2_PERSON2 = "Person2ID";
    public static final String COLUMN_ROOM2_DATE_OF_RESERVATION = "DateOfReservation";
    public static final int INDEX_ROOM2_ID = 1;
    public static final int INDEX_ROOM2_PERSON1 = 2;
    public static final int INDEX_ROOM2_PERSON2 = 3;
    public static final int INDEX_ROOM2_DATE_OF_RESERVATION = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_DESC = 2;
    public static final int ORDER_BY_ASC = 3;

    //public static final String QUERY_LIST_PERSON = "SELECT * FROM " + TABLE_PERSONS;

    public static final String QUERY_LIST_LECTURES = "SELECT " + "*" + " FROM " + TABLE_LECTURES +
            " WHERE " + COLUMN_LECTURES_PERSON + " = ?";

    public static final String INSERT_PERSON = "INSERT INTO " + TABLE_PERSONS +
            " (" + COLUMN_PERSON_NAME + ", " + COLUMN_PERSON_SURNAME + ", " + COLUMN_PERSON_TITLE + ", " +
            COLUMN_PERSON_ACADEMY + ", " + COLUMN_PERSON_DEPARTMENT + ", " +
            COLUMN_PERSON_PHONE_NUMBER + ", " + COLUMN_PERSON_EMAIL + ") VALUES( ? , ? , ? , ? , ? , ? , ? )";

    public static final String INSERT_DINNER = "INSERT INTO " + TABLE_DINNER +
            '(' + COLUMN_DINNER_PERSON_ID + ", " + COLUMN_DINNER_DATE_OF_RESERVATION + ") VALUES(?, ?)";

    public static final String INSERT_ROOM1 = "INSERT INTO " + TABLE_ROOM1 +
            '(' + COLUMN_ROOM1_PERSON + ", " + COLUMN_ROOM1_DATE_OF_RESERVATION + ") VALUES(?, ?)";

    public static final String INSERT_ROOM2 = "INSERT INTO " + TABLE_ROOM2 +
            '(' + COLUMN_ROOM2_PERSON1 + ", " + COLUMN_ROOM2_PERSON2 + ", " + COLUMN_ROOM2_DATE_OF_RESERVATION + ") VALUES(?, ?, ?)";

    public static final String UPDATE_PERSON= "UPDATE " + TABLE_PERSONS + " SET " +
            COLUMN_PERSON_NAME + " = ?," + COLUMN_PERSON_SURNAME + " = ?, " + COLUMN_PERSON_TITLE + " = ?, " +
            COLUMN_PERSON_ACADEMY + " = ?, " + COLUMN_PERSON_DEPARTMENT + " = ?, " +
            COLUMN_PERSON_PHONE_NUMBER + " = ?, " + COLUMN_PERSON_EMAIL + " = ?" + " WHERE " + COLUMN_PERSON_ID + " = ?";

    public static final String DELETE_DINNER = "DELETE FROM " + TABLE_DINNER + " WHERE " + COLUMN_DINNER_PERSON_ID + " = ? AND " + COLUMN_DINNER_DATE_OF_RESERVATION + " = ?";

    private Connection conn;

    private PreparedStatement insertIntoPerson;
    private PreparedStatement insertIntoDinner;
    private PreparedStatement insertIntoRoom1;
    private PreparedStatement insertIntoRoom2;
    //private PreparedStatement queryPerson;
    private PreparedStatement queryLectures;
    private PreparedStatement updatePerson;
    private PreparedStatement deleteDinner;

    private static Datasource instance = new Datasource();

    private Datasource() {

    }

    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            insertIntoPerson = conn.prepareStatement(INSERT_PERSON);
            insertIntoDinner = conn.prepareStatement(INSERT_DINNER, Statement.RETURN_GENERATED_KEYS);
            insertIntoRoom1 = conn.prepareStatement(INSERT_ROOM1, Statement.RETURN_GENERATED_KEYS);
            insertIntoRoom2 = conn.prepareStatement(INSERT_ROOM2, Statement.RETURN_GENERATED_KEYS);
            //queryPerson = conn.prepareStatement(QUERY_LIST_PERSON);
            queryLectures = conn.prepareStatement(QUERY_LIST_LECTURES);
            updatePerson = conn.prepareStatement(UPDATE_PERSON);
            deleteDinner = conn.prepareStatement(DELETE_DINNER);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if (insertIntoPerson != null) {
                insertIntoPerson.close();
            }

            if (insertIntoDinner != null) {
                insertIntoDinner.close();
            }

            if (insertIntoRoom1 != null) {
                insertIntoRoom1.close();
            }

            if (insertIntoRoom2 != null) {
                insertIntoRoom2.close();
            }

//            if (queryPerson != null) {
//                queryPerson.close();
//            }

            if (queryLectures != null) {
                queryLectures.close();
            }

            if (updatePerson != null) {
                updatePerson.close();
            }

            if (deleteDinner != null) {
                deleteDinner.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public List<Lecture> queryLectureForPersonId(int id) {
        try {
            queryLectures.setInt(1, id);
            ResultSet resultSet = queryLectures.executeQuery();

            List<Lecture> lectures = new ArrayList<>();
            while (resultSet.next()) {
                Lecture lecture = new Lecture();
                lecture.setLecturesID(resultSet.getInt(1));
                lecture.setNameOfLecture(resultSet.getString(2));
                lecture.setPersonID(id);
                lecture.setSummary(resultSet.getString(4));
                lecture.setDateOfRefer(resultSet.getString(5));
                lectures.add(lecture);
            }
            return lectures;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public List<Person> queryPersons(int sortOrder) {

        StringBuilder query = new StringBuilder("SELECT * FROM ");
        query.append(TABLE_PERSONS);
        if (sortOrder != ORDER_BY_NONE) {
            query.append(" ORDER BY ");
            query.append(COLUMN_PERSON_NAME);
            query.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                query.append("DESC");
            } else {
                query.append("ASC");
            }
        }

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(query.toString())) {

            List<Person> personList = new ArrayList<>();
            while (results.next()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println("Interuppted: " + e.getMessage());
                }
                Person person = new Person();
                person.setID(results.getInt(INDEX_PERSON_ID));
                person.setName(results.getString(INDEX_PERSON_NAME));
                person.setSurname(results.getString(INDEX_PERSON_SURNAME));
                person.setAcademicTitle(results.getString(INDEX_PERSON_TITLE));
                person.setAcademyID(results.getInt(INDEX_PERSON_ACADEMY));
                person.setDepartmentID(results.getInt(INDEX_PERSON_DEPARTMENT));
                person.setPhoneNumber(results.getInt(INDEX_PERSON_PHONE_NUMBER));
                person.setEmailAddress(results.getString(INDEX_PERSON_EMAIL));
                person.setNumberOfDinners(results.getInt(INDEX_PERSON_DINNER));
                person.setNumberOfNights(results.getInt(INDEX_PERSON_ROOM));
                personList.add(person);
            }

            return personList;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }


    public void insertPerson(String name, String surname, String academyTitle, int academy,
                             int department, int phoneNumber, String email) throws SQLException { // prześledzić czy wszystko jest git

        try{
            conn.setAutoCommit(false);

            insertIntoPerson.setString(1, name);
            insertIntoPerson.setString(2, surname);
            insertIntoPerson.setString(3, academyTitle);
            insertIntoPerson.setInt(4, academy);
            insertIntoPerson.setInt(5, department);
            insertIntoPerson.setInt(6, phoneNumber);
            insertIntoPerson.setString(7, email);

            int affectedRows = insertIntoPerson.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert person!");
            }
        }catch (SQLException e){
            System.out.println("Insert Person exception " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            }catch (SQLException e1){
                System.out.println("Rollback ERROR: " + e1.getMessage());
            }
        }finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
            }catch (SQLException e2){
                System.out.println("Couldn't reset auto-commit! " + e2.getMessage());
            }
        }
    }

    private int insertDinner(String name, int artistId) throws SQLException {

        insertIntoDinner.setString(1, name);
        ResultSet results = insertIntoDinner.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            // Insert the album
            insertIntoDinner.setString(1, name);
            insertIntoDinner.setInt(2, artistId);
            int affectedRows = insertIntoDinner.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert dinner!");
            }

            ResultSet generatedKeys = insertIntoDinner.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for dinner");
            }
        }
    }

    public class reservationOfRoom{

        private int person1ID;
        private int person2ID;
        private String dateOfReservation;

        public reservationOfRoom(int person1ID, String dateOfReservation) {
            this.person1ID = person1ID;
            this.dateOfReservation = dateOfReservation;

            insertRoom1();
        }

        public reservationOfRoom(int person1ID, int person2ID, int day, int month, int year) {
            this.person1ID = person1ID;
            this.person2ID = person2ID;
            this.dateOfReservation = year + "-" + month + "-" + day;

            insertRoom2();
        }


        private void insertRoom1() {

            try {
                conn.setAutoCommit(false);

                insertIntoRoom2.setInt(1, person1ID);
                insertIntoRoom2.setString(3, dateOfReservation);
                int affectedRows = insertIntoRoom2.executeUpdate();
                if (affectedRows == 1) {
                    conn.commit();
                } else {
                    throw new SQLException("The room insert failed");
                }

            } catch (Exception e) {
                System.out.println("Insert room exception: " + e.getMessage());
                try {
                    System.out.println("Performing rollback");
                    conn.rollback();
                } catch (SQLException e2) {
                    System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
                }
            } finally {
                try {
                    System.out.println("Resetting default commit behavior");
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    System.out.println("Couldn't reset auto-commit! " + e.getMessage());
                }

            }
        }

        private void insertRoom2() {

            try {
                conn.setAutoCommit(false);

                insertIntoRoom2.setInt(1, person1ID);
                insertIntoRoom2.setInt(2, person2ID);
                insertIntoRoom2.setString(3, dateOfReservation);
                int affectedRows = insertIntoRoom2.executeUpdate();
                if (affectedRows == 1) {
                    conn.commit();
                } else {
                    throw new SQLException("The room insert failed");
                }

            } catch (Exception e) {
                System.out.println("Insert room exception: " + e.getMessage());
                try {
                    System.out.println("Performing rollback");
                    conn.rollback();
                } catch (SQLException e2) {
                    System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
                }
            } finally {
                try {
                    System.out.println("Resetting default commit behavior");
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    System.out.println("Couldn't reset auto-commit! " + e.getMessage());
                }

            }
        }

    }



    public boolean deleteDinner(int id, int day, int month, int year){ // zmienić poniższe linie na delete
        try{
            String dateOfReservarionString = year + "-" + month + "-" + day;
            deleteDinner.setInt(1, id);
            deleteDinner.setString(2, dateOfReservarionString);
            int affectedRecord = deleteDinner.executeUpdate();

            return affectedRecord == 1;

        }catch (SQLException e){
            System.out.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    public boolean updatePersonMethod(String newName, String newSurname, String newAcademyTitle, int newAcademy,
                                   int newDepartment, int newPhoneNumber, String newEmail, int IDPerson) {
        try {
            conn.setAutoCommit(false);

            updatePerson.setString(1, newName);
            updatePerson.setString(2, newSurname);
            updatePerson.setString(3, newAcademyTitle);
            updatePerson.setInt(4, newAcademy);
            updatePerson.setInt(5, newDepartment);
            updatePerson.setInt(6, newPhoneNumber);
            updatePerson.setString(7, newEmail);
            updatePerson.setInt(8, IDPerson); // changes will be for person with ID which is insert here

            updatePerson.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update Person exception " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Rollback ERROR: " + e1.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                conn.setAutoCommit(true);
                return true;
            } catch (SQLException e2) {
                System.out.println("Couldn't reset auto-commit! " + e2.getMessage());
                return false;
            }
        }
    }

    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_LECTURES;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.format("Column %d in the lecture table is names %s\n",
                        i, meta.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) AS count FROM " + table;
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            int count = results.getInt("count");

            System.out.format("Count = %d\n", count);
            return count;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }






}
