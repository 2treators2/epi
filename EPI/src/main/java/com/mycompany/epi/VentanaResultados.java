/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.epi;

/**
 *
 * @author sebag
 */
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
public class VentanaResultados extends JFrame{
    private JLabel textoR,textoH,textoV,textoA,textoG;
    private JPanel panel1;
    protected H2V electrolizador;
    
    public VentanaResultados(){
        //Config
        setTitle("Error");
        setSize(500,100);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        textoR = new JLabel("Algun dato introducido no es valido");
        this.add(textoR);
    }
    
    public VentanaResultados(H2V electrolizador){
        //Config
        setTitle("Resultados");
        setSize(1000,600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        this.electrolizador = electrolizador;
        //Widgets
        textoR = new JLabel("Costes");
        textoH = new JLabel("Hidrogeno Generado: " + String.valueOf(electrolizador.calcularProduccion()) + " L");
        textoV = new JLabel("\nCoste Hidrogeno Verde: "+ String.valueOf(electrolizador.calcularProduccion()*6.5) +" USD");
        textoA = new JLabel("\nCoste Hidrogeno Azul: "+ String.valueOf(electrolizador.calcularProduccion()*2.5)+" USD");
        textoG = new JLabel("\nCoste Hidrogeno Gris: "+ String.valueOf(electrolizador.calcularProduccion()*1.5)+" USD");
        gbc.insets = new Insets(25,25,25,25);
        gbc.gridx=0;
        gbc.gridy=0;
        panel1.add(textoR,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        panel1.add(textoH,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        panel1.add(textoG,gbc);
        gbc.gridx=0;
        gbc.gridy=3;
        panel1.add(textoA,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        panel1.add(textoV,gbc);
        this.add(this.graficoBarras(electrolizador));
        this.add(panel1);
        this.revalidate();
        this.repaint();
        
    }
     public ChartPanel graficoBarras(H2V electrolizador){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(electrolizador.calcularProduccion()*1.5, "Hidrogeno Gris", "Valor 1.5$/Kg");
        dataset.addValue(electrolizador.calcularProduccion()*2.5, "Hidrógeno Azul", "Valor 2.5$/Kg");
        dataset.addValue(electrolizador.calcularProduccion()*6.5, "Hidrógeno Verde", "Valor 6.5$/Kg");

        JFreeChart chart = ChartFactory.createBarChart(
                "Gráfico de Barras", // Título
                "Años",             // Etiqueta del eje X
                "Ventas",           // Etiqueta del eje Y
                dataset
        );
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setBounds(0, 0, 750, 750);
        
        return chartPanel;
    }
}
