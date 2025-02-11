import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//Importo clases como awt, awt event y swing para crear la interfaz gráfica:
//Botones, etiquetas, paneles y click de boton

/*Creo una clase que es una aplicación en forma de ventana.
Defino algunas variables de instancia:
MainFont para la fuente de texto principal.
tfFirstName y tfLastName para los campos de texto nombre y apellido.
lbWerlcome para una etiqueta de bienvenida*/
public class NameForm extends JFrame{
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName , tfLastName;
    JLabel lbWelcome;

    //Método que configura todos los componentes de la interfaz.
    public void initialize(){
        /*FORM PANEL */
        /*Aquí se crean etiquetas (JLabel) y campos de texto (JTextField) para el nombre y apellido,
        y se les asigna la fuente principal. Luego, estos componentes se añaden a un panel (JPanel) 
        con un GridLayout para organizarlos en una cuadrícula de 4 filas y 1 columna.*/
        JLabel lbFirstName = new JLabel("First Name");
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel fromPanel = new JPanel();
        fromPanel.setLayout(new GridLayout(4,1,5,5));
        fromPanel.setOpaque(false);
        fromPanel.add(lbFirstName);
        fromPanel.add(tfFirstName);
        fromPanel.add(lbLastName);
        fromPanel.add(tfLastName);

        /*WELCOME LABEL */
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        /*Buttons panel */
        /*Se crean dos botones (JButton): uno para confirmar (btnOK) y otro para limpiar (btnClear). 
        Ambos botones tienen asignados ActionListener que definen las acciones a realizar cuando se hace clic en ellos. 
        btnOK actualiza la etiqueta de bienvenida con el nombre ingresado, 
        y btnClear limpia los campos de texto y la etiqueta de bienvenida.
        Estos botones se añaden a un panel con un GridLayout de 1 fila y 2 columnas.*/
        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
               String firstName = tfFirstName.getText();
               String lastName = tfLastName.getText();
               lbWelcome.setText("Hello " + firstName + " " + lastName);
            }
            
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("");
            }
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,5,5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);

        // Main Panel
        /*Se crea un panel principal (mainPanel) con un BorderLayout.
        Se añaden el panel del formulario (fromPanel) en la parte superior (BorderLayout.NORTH),
        la etiqueta de bienvenida (lbWelcome) en el centro (BorderLayout.CENTER), 
        y el panel de botones (buttonsPanel) en la parte inferior (BorderLayout.SOUTH). 
        Se configuran algunos atributos de la ventana como el título, tamaño, y la operación de cierre.
        Finalmente, se hace visible la ventana.*/
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(fromPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
