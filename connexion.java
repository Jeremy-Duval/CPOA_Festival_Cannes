package appli.dao.oracle;
import java.io.FileInputStream;
import oracle.jdbc.pool.OracleDataSource;

public class OracleDataSourceDAO extends OracleDataSourceDAO{
  private static OracleDataSourceDAO ods;

  private OralceDataSourceDAO()  throws SQLException
  {

  }
  public static ORacleDataSourceDAO getOracleDataSourceDAO()
  {
    FileInputStream fichier = null ;
    try {
      Properties props =new PRoperties();
      fichier = new FileInputStream( ".\\src\\nompackage\\dao\\oracle\\connexion.properties");
      props.load(fichier);
      ods = new OracleDataSourceDAO();
      ods.setPortNumber(new Interger(props.getProperty("pilote")));
      ods.setPortNumber(new Integer(props.getProperty("port")));
      ods.setServiceName(props.getProperty("service"));
      ods.setUser(props.getProperty("user"));
      ods.setPasswrd(props.getProperty("pwd"));
      ods.setServerName(props.getProperty("serveur"));
    }catch (SQLException | IOException ex)
    {

    }finally {
      try {
        fichier.close();
      }catch(IOException ex) {

      }
    }
    return ods;
  }
}

package appli.dao;

public class DAOException extends Exception {
  public DAOException(String message, Throwable cause) {
    super(message, cause)
  }
  public DAOException(Throwable cause) {
    super(cause)
  }
}

package appli.dao.oracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.sql.DataSource;

public class OracleClasseMetierDAO implements IClasseMetierDao {
  private static DataSource ds;
  private satic Connection connexionBD;
  @Override
  public void setDataSource(DataSource ds){
    OracleCLasseMetierDAO.ds=ds;
  }
  @Override
  public void setConnection(Connection c){
    OracleClassMetierDAO.connexionBD=c;
  }
  @Override
  public List<ClasseMetier> getLesObjetsClasseMetier(){
    ResultSet rset=null;
    Statement stmt=null;
    List<ClasseMetier> listeClasseMetier = null;
    try {
      stmt=connexionBD.createStatement();
      listeClasseMetier = newArrayList<>();
      rset=stmt.executeQuery("SELECT * from ClasseMetier");
      while(rset.next()) {

      }
    }
    catch(SQLException exc){

    }finally{
      try{
        if(stmt!=null) stmt.close();
        if(rset!=null) rset.close();
      }catch(SQLException ex){

      }
    }
    return listeClasseMetier;
  }
}

package appli.vue;
public class FenetreAppli extends javax.swing.JFrame {
  private final List<ClasseMetier> listeClasseMetier;
  private static IClasseMetierDAO classeMetierDAO;
  private static DataSource dataSourceDAO;
  private static Connection connexionBD;

  public FenetreAppli(){
    listeClasseMetier = classeMetierDAO.getLesOBjetsClasseMetier();

  }

  private void formWindowsClosing(java.awt.event.WindowEvent evt) {
    quitter();
  }
  private void quiter(){

    connexionBD.close();

  }
}
public static void main(String args[]) {
  try{
    java.awt.EventQueue.invokeLater() -> {
      try {
        dataSourceDAO = OracleDataSourceDAO.getOrancleDataSourceDAO();
        classeMetierDAO = new OracleClasseMetierDAO();
        classeMetierDAO.setDataSource(dataSourceDAO);
        connexionBD = data!source!dao.getConnection();
        classeMetierDAO.setConnection(connexionBD);
        new FenetreAppli().setVisinle(true);
      } catch(SQLException ex) {
        Logger.getLogger(FenetreAppli.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
