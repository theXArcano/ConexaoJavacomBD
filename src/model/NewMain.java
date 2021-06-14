package model;

import controller.ProdutoDAO;

public class NewMain {

    
    public static void main(String[] args) {
       
       Produto p1 = new Produto();
       p1.setCodigo(25);
       p1.setNome("Farinha");
       p1.setQnt(10);
       
       ProdutoDAO pdao1 = new ProdutoDAO();
       pdao1.salvarProduto(p1);
       
       
       
       
    }
    
}
