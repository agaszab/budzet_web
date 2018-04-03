import org.springframework.ui.Model;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class PrzychodyDao {

        private static final String URL = "jdbc:mysql://localhost:3306/wydatki?characterEncoding=utf8";
        private static final String USER = "root";
        private static final String PASS = "kociakolka";
        private Connection connection;


        public PrzychodyDao() {


            try {
                Class.forName ("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection (URL, USER, PASS);
            } catch (ClassNotFoundException e) {
                System.out.println("No driver found");
            } catch (SQLException e) {
                System.out.println("Couldnot establishconnection");
            }
        }


        public void show(String type ) throws SQLException {
            Statement statement = connection.createStatement();
            String query= "select * from home_budget where type ='"+type+"' ";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                long id = resultSet.getLong("id");
                type= resultSet.getString("type");
                String description= resultSet.getString("description");
                long amount =resultSet.getLong("amount");
                Date date=resultSet.getDate("date");

                System.out.println (id+ " " + type + "  " +description+"  KWOTA: "+amount+" DNIA: "+date);
            }
        }



        public void save (Przychody przychody) {
            final String sql="insert into home_budget (type, description, amount, date ) values (?, ?, ?,?,?)";
            try
            {
                PreparedStatement prepStmt = connection.prepareStatement (sql);
                prepStmt.setString(2,przychody.getType ());
                prepStmt.setString(3,przychody.getDescription());
                prepStmt.setLong(4,przychody.getAmount());
                LocalDate date=przychody.getDate();
                Date sqlDate=Date.valueOf(date);
                prepStmt.setDate(5, sqlDate);
                prepStmt.executeUpdate();
            }
            catch(SQLException e ) {
                System.out.println( "Could not save record ");
                e.printStackTrace();
            }
        }



        public void close() {
            try {
                connection.close();
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }

    public Przychody wczytaj (String rodzaj) throws SQLException {
        Scanner scan=new Scanner(System.in);
        System.out.println("Wpisz pozycję do bazy przychodów/wydatków");
        System.out.println("Opis transakcji:");
        String opis=scan.nextLine();
        System.out.println("Kwota:");
        long kwota=scan.nextLong();
        LocalDate data=LocalDate.now();
        Przychody przychody=new Przychody();
        przychody.setType(rodzaj);
        przychody.setDescription(opis);
        przychody.setAmount(kwota);
        przychody.setDate(data);

        return przychody;
    }

    public String addForm (Model model, String typ) {
        model.addAttribute("newPrzychody" , new Przychody());
        return "formularz";
    }

    }


