/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.epi;

/**
 *
 * @author sebag
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable;
import javax.swing.JPanel;
import javax.swing.JSlider;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaDatos extends JFrame implements ActionListener, ChangeListener{
    private JLabel textoCaudal, textoVoltaje, textoCorriente, textoHoras, textoEnergiaInicial;
    private JTextField cajaCaudal, cajaVoltaje, cajaCorriente, cajaHoras, cajaEnergiaInicial;
    private JSlider sliderCaudal, sliderVoltaje, sliderCorriente;
    private JButton botonGraficar;
    private JFrame Grafico;
    public VentanaDatos(){
        //Config
        
        setTitle("Calculadora Coste Hidrogeno");
        setSize(800,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        Grafico = new JFrame();
        GridBagConstraints gbc = new GridBagConstraints();
       
        //Widgets
        textoCaudal = new JLabel("Caudal Vt");
        sliderCaudal = new JSlider(8,48,28);
        Hashtable<Integer, JLabel> labels_sliderC = new Hashtable<>();
        labels_sliderC.put(8, new JLabel("8"));
        labels_sliderC.put(28, new JLabel("28"));
        labels_sliderC.put(48, new JLabel("48"));
        sliderCaudal.setLabelTable(labels_sliderC);
        sliderCaudal.setPaintLabels(true);
        cajaCaudal = new JTextField(String.valueOf(sliderCaudal.getValue()),5);
        cajaCaudal.setEditable(false);
        cajaCaudal.setHorizontalAlignment(cajaCaudal.CENTER);
        
        textoVoltaje = new JLabel("Voltaje V");
        sliderVoltaje = new JSlider(250,350,300);
        Hashtable<Integer, JLabel> labels_sliderV = new Hashtable<>();
        labels_sliderV.put(250, new JLabel("250"));
        labels_sliderV.put(300, new JLabel("300"));
        labels_sliderV.put(350, new JLabel("350"));
        sliderVoltaje.setLabelTable(labels_sliderV);
        sliderVoltaje.setPaintLabels(true);
        cajaVoltaje = new JTextField(String.valueOf(sliderVoltaje.getValue()),5);
        cajaVoltaje.setEditable(false);
        cajaVoltaje.setHorizontalAlignment(cajaVoltaje.CENTER);
        
        textoCorriente = new JLabel("Corriente A");
        sliderCorriente = new JSlider(1000,3000,2000);
        Hashtable<Integer, JLabel> labels_sliderI = new Hashtable<>();
        labels_sliderI.put(1000, new JLabel("1000"));
        labels_sliderI.put(2000, new JLabel("2000"));
        labels_sliderI.put(3000, new JLabel("3000"));
        sliderCorriente.setLabelTable(labels_sliderI);
        sliderCorriente.setPaintLabels(true);
        cajaCorriente = new JTextField(String.valueOf(sliderCorriente.getValue()),5);
        cajaCorriente.setEditable(false);
        cajaCorriente.setHorizontalAlignment(cajaCorriente.CENTER);
        
        textoHoras = new JLabel("Horas");
        cajaHoras = new JTextField(15);
        textoEnergiaInicial = new JLabel("Cantidad Inicial L");
        cajaEnergiaInicial = new JTextField(15);
        botonGraficar = new JButton("Graficar Coste");
        sliderCaudal.addChangeListener(this);
        sliderVoltaje.addChangeListener(this);
        sliderCorriente.addChangeListener(this);
        botonGraficar.addActionListener(this);
        //Agregar y configurar GridBag
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets = new Insets(25,25,25,25);
        this.add(textoCaudal,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        this.add(sliderCaudal,gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        this.add(cajaCaudal,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(textoVoltaje,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        this.add(sliderVoltaje,gbc);
        gbc.gridx=2;
        gbc.gridy=2;
        this.add(cajaVoltaje,gbc);
        gbc.gridx=0;
        gbc.gridy=4;
        this.add(textoCorriente,gbc);
        gbc.gridx=1;
        gbc.gridy=4;
        this.add(sliderCorriente,gbc);
        gbc.gridx=2;
        gbc.gridy=4;
        this.add(cajaCorriente,gbc);
        gbc.gridx=0;
        gbc.gridy=6;
        this.add(textoHoras,gbc);
        gbc.gridx=1;
        gbc.gridy=6;
        this.add(cajaHoras,gbc);
        gbc.gridx=0;
        gbc.gridy=8;
        this.add(textoEnergiaInicial,gbc);
        gbc.gridx=1;
        gbc.gridy=8;
        this.add(cajaEnergiaInicial,gbc);
        gbc.gridx=6;
        gbc.gridy=4;
        this.add(botonGraficar,gbc);
        this.revalidate();
        this.repaint();     
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== botonGraficar){
            Grafico.dispose();
            try{
            double caudal = sliderCaudal.getValue();
            double voltaje = sliderVoltaje.getValue();
            double corriente = sliderCorriente.getValue();
            double horas = Double.parseDouble(cajaHoras.getText()); 
            double energiaInicial = Double.parseDouble(cajaEnergiaInicial.getText());
                if(energiaInicial !=0){    
                H2V produccion = new H2V(caudal,voltaje,corriente,horas,energiaInicial);
                Grafico = new VentanaResultados(produccion);
                }
                else{
                H2V produccion = new H2V(caudal,voltaje,corriente,horas);
                Grafico = new VentanaResultados(produccion);
                }
            }
            catch(NumberFormatException c){
            Grafico = new VentanaResultados();
            }
        }
    }
    @Override
    public void stateChanged(ChangeEvent ce){
        JSlider fuente = (JSlider)ce.getSource();
        if(fuente.getValueIsAdjusting()){
            if(fuente == sliderCaudal){
                cajaCaudal.setText(String.valueOf(sliderCaudal.getValue()));
            }
            else if(fuente==sliderVoltaje){
              cajaVoltaje.setText(String.valueOf(sliderVoltaje.getValue()));
            }
            else if(fuente==sliderCorriente){
                cajaCorriente.setText(String.valueOf(sliderCorriente.getValue()));
            }
        }        
    }
}
