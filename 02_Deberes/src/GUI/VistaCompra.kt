package VistaCompras

import java.awt.Color
import java.awt.Dimension
import javax.swing.*

class VistaCompras (titulo:String):JFrame(){
    init {
        createUI(titulo)
    }


    private fun createUI(title: String) {

        setTitle(title)


        val btnInsertar = JButton("INSERT");
        val btnLeer = JButton("READ");
        val btnBorrar = JButton("DELETE");
        val btnActualizar = JButton("UPDATE");


        var listbotons= arrayOf<JButton>(btnInsertar,btnLeer,btnBorrar,btnActualizar);

        val botones = listbotons.map {
            JButton(it.text).apply {
                background= Color.BLUE
                preferredSize= Dimension(60,40)
                //minimumSize = Dimension(90, 40)
                //background = it.
                isOpaque = true
            }
        }


        createLayout(botones);


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 200)
        setLocationRelativeTo(null)
    }

    public fun createAndShowVistaCompras() {

        val frame = VistaCompras("Simple")
        frame.isVisible = true
    }


    private fun createLayout(arg: List<JComponent>) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true;
        gl.autoCreateGaps = true

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
            .addComponent(arg[1])
            .addComponent(arg[2])
            .addComponent(arg[3]));

        pack();
    }


    fun action(){
        println("Bienvenidos");
    }
}

