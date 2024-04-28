package application;

import entities.Cliente;
import entities.ClienteCestaBasica;
import entities.ClienteServicosEspecialidade;
import entities.Listas;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JanelaComAbas extends JFrame {

    JTabbedPane abas = new JTabbedPane();
    JPanel panelCadastro = new JPanel();
    JPanel panelBusca = new JPanel();
    JPanel panelCesta = new JPanel();
    Listas listas = new Listas();

    private JTextField textFieldNome;
    private JTextField textFieldDataNascimento;
    private JTextField textFieldEndereco;
    private JTextField textFieldTelefone;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataEncerramento;
    private JComboBox<String> comboBoxServico;
    private JComboBox<String> comboBoxEspecialidade;
    private JComboBox<String> comboBoxMedico;
    private JComboBox<String> comboBoxEspecialidadeBusca;
    private JComboBox<String> comboBoxMedicoBusca;
    private ArrayList<ClienteServicosEspecialidade> pacientes = new ArrayList<>();
    private ArrayList<ClienteCestaBasica> clientes = new ArrayList<>();
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModelCesta;
    private JTable table;
    private JTable tableCesta;

    public JanelaComAbas() {
        configurarJanela();
        add(BorderLayout.CENTER, abas);
        abas.addTab("Cadastro", panelCadastro);
        abas.addTab("Busca", panelBusca);
        abas.addTab("Cesta Basica", panelCesta);
        abas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(abas.getSelectedIndex() == 2){
                    atualizarTabelaCesta();
                }
            }
        });

        panelCadastro.setBackground(Color.LIGHT_GRAY);
        panelBusca.setBackground(Color.LIGHT_GRAY);
        panelCesta.setBackground(Color.LIGHT_GRAY);
        panelCadastro.setLayout(new GridBagLayout());



        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;


        panelCadastro.add(new JLabel("Nome:"), gbc);

        gbc.gridy++;
        textFieldNome = new JTextField(20);
        panelCadastro.add(textFieldNome, gbc);

        gbc.gridy++;
        panelCadastro.add(new JLabel("Data de Nascimento:"), gbc);

        gbc.gridy++;
        textFieldDataNascimento = new JTextField(20);
        panelCadastro.add(textFieldDataNascimento, gbc);

        gbc.gridy++;
        panelCadastro.add(new JLabel("Endereço:"), gbc);

        gbc.gridy++;
        textFieldEndereco = new JTextField(20);
        panelCadastro.add(textFieldEndereco, gbc);

        gbc.gridy++;
        panelCadastro.add(new JLabel("Telefone:"), gbc);

        gbc.gridy++;
        textFieldTelefone = new JTextField(20);
        panelCadastro.add(textFieldTelefone, gbc);

        gbc.gridy++;
        panelCadastro.add(new JLabel("Data de Início:"), gbc);

        gbc.gridy++;
        textFieldDataInicio = new JTextField(20);
        panelCadastro.add(textFieldDataInicio, gbc);

        gbc.gridy++;
        panelCadastro.add(new JLabel("Data de Encerramento:"), gbc);

        gbc.gridy++;
        textFieldDataEncerramento = new JTextField(20);
        panelCadastro.add(textFieldDataEncerramento, gbc);

        gbc.gridy++;
        panelCadastro.add(new JLabel("Serviço:"), gbc);

        gbc.gridy++;
        comboBoxServico = new JComboBox<>();
        panelCadastro.add(comboBoxServico, gbc);
        comboBoxServico.addItem("Cesta Básica");
        comboBoxServico.addItem("Tratamento");

        comboBoxServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String servicoSelecionado = (String) comboBoxServico.getSelectedItem();
                if (servicoSelecionado.equals("Tratamento")) {
                    comboBoxEspecialidade.setEnabled(true);
                    comboBoxMedico.setEnabled(true);
                } else {
                    comboBoxEspecialidade.setEnabled(false);
                    comboBoxMedico.setEnabled(false);
                }
            }
        });

        gbc.gridy++;
        panelCadastro.add(new JLabel("Especialidade:"), gbc);

        gbc.gridy++;
        comboBoxEspecialidade = new JComboBox<>();
        for (String servico : listas.getListaEspecialidades()) {
            comboBoxEspecialidade.addItem(servico);
        }
        panelCadastro.add(comboBoxEspecialidade, gbc);

        comboBoxEspecialidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencherMedicos();
            }
        });


        gbc.gridy++;
        panelCadastro.add(new JLabel("Médico:"), gbc);

        gbc.gridy++;
        comboBoxMedico = new JComboBox<>();
        comboBoxMedico.addItem("Selecione");
        panelCadastro.add(comboBoxMedico, gbc);

        comboBoxEspecialidade.setEnabled(false);
        comboBoxMedico.setEnabled(false);


        gbc.gridy++;
        JButton btnCadastrar = new JButton("Cadastrar");
        panelCadastro.add(btnCadastrar, gbc);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        gbc.gridy = 0;
        panelBusca.setLayout(new GridBagLayout());
        panelBusca.add(new JLabel("Especialidade:"), gbc);

        gbc.gridy++;
        comboBoxEspecialidadeBusca = new JComboBox<>();
        for (String especialidade : listas.getListaEspecialidades()) {
            comboBoxEspecialidadeBusca.addItem(especialidade);
        }
        panelBusca.add(comboBoxEspecialidadeBusca, gbc);

        gbc.gridy++;
        panelBusca.add(new JLabel("Médico:"), gbc);

        gbc.gridy++;
        comboBoxMedicoBusca = new JComboBox<>();
        comboBoxMedicoBusca.addItem("Selecione");
        panelBusca.add(comboBoxMedicoBusca, gbc);

        comboBoxEspecialidadeBusca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencherMedicosBusca();
            }
        });


        gbc.gridy++;
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("Nome");
        tableModel.addColumn("Nascimento");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Início");
        tableModel.addColumn("Especialidade");
        tableModel.addColumn("Médico");

        atualizarTabela(pacientes);

        TableColumn column = null;
        for (int i = 0; i < 7; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 1 || i == 3 || i == 5 || i == 2) {
                column.setPreferredWidth(150);
            } else {
                column.setPreferredWidth(100);
            }
        }
        panelBusca.add(table, gbc);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        panelBusca.add(scrollPane, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        JButton btnBuscar = new JButton("Buscar");
        panelBusca.add(btnBuscar, gbc);

        btnBuscar.addActionListener(new BuscarActionListener(listas, comboBoxEspecialidadeBusca, comboBoxMedicoBusca, table));






        tableModelCesta = new DefaultTableModel();
        tableCesta = new JTable(tableModelCesta);
        tableModelCesta.addColumn("Nome");
        tableModelCesta.addColumn("Nascimento");
        tableModelCesta.addColumn("Endereço");
        tableModelCesta.addColumn("Telefone");
        tableModelCesta.addColumn("Início");
        tableModelCesta.addColumn("Encerramento");
        panelCesta.add(tableCesta, gbc);

        JScrollPane scrollPaneCesta = new JScrollPane(tableCesta);
        scrollPaneCesta.setPreferredSize(new Dimension(800, 600));
        panelCesta.add(scrollPaneCesta, gbc);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void atualizarTabelaCesta() {
        if (tableModelCesta.getRowCount() > 0) {
            tableModelCesta.setRowCount(0);
        }

        clientes = listas.getListaClienteCestaBasica();

        for (ClienteCestaBasica cliente : clientes) {
            Object[] row = {
                    cliente.getNomeCompleto(),
                    cliente.getDataNascimento(),
                    cliente.getEndereco(),
                    cliente.getTelefone(),
                    cliente.getDataInicio(),
                    cliente.getDataEncerramento()
            };
            tableModelCesta.addRow(row);
        }
    }

    private void atualizarTabela(ArrayList<ClienteServicosEspecialidade> pacientes) {
        tableModel.setRowCount(0);

        for (ClienteServicosEspecialidade paciente : pacientes) {
            Object[] rowData = {
                    paciente.getNomeCompleto(),
                    paciente.getDataNascimento(),
                    paciente.getEndereco(),
                    paciente.getTelefone(),
                    paciente.getDataInicio(),
                    paciente.getEspecialidade(),
                    paciente.getNomeMedico()
            };
            tableModel.addRow(rowData);
        }
    }


    public void configurarJanela() {
        setTitle("Janela Com Abas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarCliente() {

        String nome = textFieldNome.getText();
        String dataNascimento = textFieldDataNascimento.getText();
        String endereco = textFieldEndereco.getText();
        String telefone = textFieldTelefone.getText();
        String dataInicio = textFieldDataInicio.getText();
        String dataEncerramento = textFieldDataEncerramento.getText();
        String servico = (String) comboBoxServico.getSelectedItem();
        String especialidade = (String) comboBoxEspecialidade.getSelectedItem();
        String medico = (String) comboBoxMedico.getSelectedItem();


        if (nome.isEmpty() || dataNascimento.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || dataInicio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }


        Cliente cliente;
        if (servico.equals("Cesta Básica")) {
            cliente = new ClienteCestaBasica(nome, dataNascimento, endereco, telefone, dataInicio, dataEncerramento);
        } else {
            if (especialidade.isEmpty() || medico == null || medico.equals("Selecione")) {
                JOptionPane.showMessageDialog(this, "Especialidade e médico são obrigatórios para tratamentos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            cliente = new ClienteServicosEspecialidade(nome, dataNascimento, endereco, telefone, dataInicio, especialidade, medico);

        }

        if (cliente instanceof ClienteCestaBasica) {
            listas.adicionarClienteCestaBasica((ClienteCestaBasica) cliente);
            JOptionPane.showMessageDialog(this, "Cliente da Cesta Basica cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            listas.adicionarPaciente(medico, (ClienteServicosEspecialidade) cliente);
            JOptionPane.showMessageDialog(this, "Paciente do tratamento cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        limparCampos();
    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldDataNascimento.setText("");
        textFieldEndereco.setText("");
        textFieldTelefone.setText("");
        textFieldDataInicio.setText("");
        textFieldDataEncerramento.setText("");
        comboBoxServico.setSelectedIndex(0);
        comboBoxEspecialidade.setSelectedIndex(0);
        comboBoxMedico.removeAllItems();
        textFieldDataEncerramento.setText("");
    }



    private void preencherMedicos() {
        String especialidadeSelecionada = (String) comboBoxEspecialidade.getSelectedItem();
        comboBoxMedico.removeAllItems();

        if (especialidadeSelecionada.equals("Fisioterapia")) {
            for (String medico : listas.getListaMedicosFisioterapia()) {
                comboBoxMedico.addItem(medico);
            }
        } else if (especialidadeSelecionada.equals("Fonoaudiologia")) {
            for (String medico : listas.getListaMedicosFonoaudiologia()) {
                comboBoxMedico.addItem(medico);
            }
        } else if (especialidadeSelecionada.equals("Tratamento Neural")) {
            for (String medico : listas.getListaMedicosTratamentoNeural()) {
                comboBoxMedico.addItem(medico);
            }
        } else if (especialidadeSelecionada.equals("Psicologia")) {
            for (String medico : listas.getListaMedicosPsicologia()) {
                comboBoxMedico.addItem(medico);
            }
        }
    }

    private void preencherMedicosBusca() {
        String especialidadeSelecionada = (String) comboBoxEspecialidadeBusca.getSelectedItem();
        comboBoxMedicoBusca.removeAllItems();

        if (especialidadeSelecionada.equals("Fisioterapia")) {
            for (String medico : listas.getListaMedicosFisioterapia()) {
                comboBoxMedicoBusca.addItem(medico);
            }
        } else if (especialidadeSelecionada.equals("Fonoaudiologia")) {
            for (String medico : listas.getListaMedicosFonoaudiologia()) {
                comboBoxMedicoBusca.addItem(medico);
            }
        } else if (especialidadeSelecionada.equals("Tratamento Neural")) {
            for (String medico : listas.getListaMedicosTratamentoNeural()) {
                comboBoxMedicoBusca.addItem(medico);
            }
        } else if (especialidadeSelecionada.equals("Psicologia")) {
            for (String medico : listas.getListaMedicosPsicologia()) {
                comboBoxMedicoBusca.addItem(medico);
            }
        }
    }

}
