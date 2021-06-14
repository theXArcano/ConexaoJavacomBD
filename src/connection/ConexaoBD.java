package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBD {
    
//caminho e porta do servidor
    private String servidor = "localhost:3306";
    
//nome da base de dados que irá se conectar
    private String baseDeDados = "Produtos";
    
//Caminho do BD
    private String url = "jdbc:mysql://" + servidor + "/" +baseDeDados;

//Identificar o serviço(driver) do BD
    private String driver = "com.mysql.cj.jdbc.Driver";
    
//Usuário e senha de acesso ao BD;
    private String usuario = "root";
    private String senha = "senhabd";
    
    //responsável pela conexão com o BD
        public Connection conexao;
        
        
        public void conectarBD(){
        try {
            Class.forName(driver); //Verifica se o Driver existe na máquina
             //DriverManager é onde é feito a conexão passando a url, usuario e senha
             //do banco
             conexao = DriverManager.getConnection(url,usuario,senha);
             System.out.println("Conexão Realizada com sucesso!");
            }   
            catch (SQLException ex){
                System.out.println("Driver não encontrado:\n" +ex);
            }        
            catch (ClassNotFoundException ex) {
            System.out.println("\nProblemas na conexão com o banco: \n" +ex);
            }
        }
    
        public void desconectarBD(){
            try{
            conexao.close(); //encerra a conexao
            System.out.println("Banco Desconectado com sucesso!");
            }
            catch (SQLException ex){
                System.out.println("Erro ao tentar desconectar do banco\n" +ex);
            }
        }
}
