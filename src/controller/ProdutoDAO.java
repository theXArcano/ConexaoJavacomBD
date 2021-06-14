
package controller;

import connection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Produto;

public class ProdutoDAO {
    
    private ConexaoBD con = new ConexaoBD();
    
    public void salvarProduto(Produto produto){
    
        con.conectarBD();
        //comando sql
        String sql = "insert into produtos(codigop, nomep,qntp) values (?,?,?)";
       
        //Representa uma instrução SQL
        PreparedStatement pst;
        
        try {
        
            //Transformação da string sql em instrução SQL
            //Feito pelo objeto conexao do tipo Connection da classe
            //ConexaoBD
            pst = con.conexao.prepareStatement(sql);
            
            //Substitui o 1º ponto de interrogação da consulta
            //pelo valor da variável cpd da classe Produto
            pst.setInt (1,Produto.getCodigo());
            
            //Substitui o 2º ponto de interrogação da consulta
            //pelo valor da variável cpd da classe Produto
            pst.setString (2, Produto.getNome());
            
            //Substitui o 2º ponto de interrogação da consulta
            //pelo valor da variável cpd da classe Produto
            pst.setInt (3,Produto.getQnt());
            
            pst.execute(); //Executa o comando SQL
            
            JOptionPane.showMessageDialog(null,"Produto Cadastrado com sucesso!");
        } 
        
        catch(SQLException ex){
            System.out.println("Erro ao salvar produto:\n" +ex);
        }
        
        
        }
                
        }
    
    
    
  //  public void excluirProduto(Produto produt){}

