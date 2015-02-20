/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utilidades;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrador
 */
public class Correo {
    private String mensaje;
    private String destino;
    private String origen;
    private String asunto;
    private String clave;

    
//    public void mensajeSolicitud(Solicitudprestamo sp,List<Cuota> lcuo){
//        setDestino(sp.getAsociado().getCorreo());
//        setAsunto("Confirmacion de solicitud de prestamo");
//        setMensaje("Cordial Saludo asociado(a) "+sp.getAsociado().getNombres()+" "+sp.getAsociado().getApellidos()+"\n"+
//                   "usted ha realizado una solicitud de prestamo con No: "+sp.getCodigo()+" por valor de: "+
//                   sp.getMonto()+" pactado a "+sp.getNcuotas()+" cuotas, detalles de la Tranzaccion:\n"+
//                   "Tipo de Credito: "+sp.getTipoCredito()+"\nTipo de Prestamo: "+sp.getTipoPrestamo()+
//                   "\nFecha: "+sp.getFecha()+"\nTaza: "+sp.getTasa()+"\nValor Cuota: "+sp.getValorcuota()+"\n");        
////        detallesProyeccion(lcuo);
//        origen="jcmm80@gmail.com";clave="02127132";
//        enviar();
//    }
//    
//    public void detallesProyeccion(List<Cuota> lcuo){
//            String detalles="Numero     Fecha       Valor       Capital     Interes     Saldo       Estado\n";
//        for(int i=0;i<lcuo.size();i++){
//            Cuota cuo=lcuo.get(i);
//            detalles=detalles+cuo.getNumCuota()+"\t"+cuo.getFecha()+"\t"+cuo.getValor()+"\t"+cuo.getCapital()+
//                    "\t"+cuo.getInteres()+"\t"+cuo.getSaldo()+"\t"+cuo.getEstado()+"\n";
//        }
//        setMensaje(getMensaje()+detalles);
//    }
    
    public void enviar(){
        try
        {
            // Propiedades de la conexi�n
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", this.getOrigen());
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.getOrigen()));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(this.getDestino()));
            message.setSubject(this.getAsunto());
            message.setText(this.getMensaje());

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(this.getOrigen(), this.getClave());
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }



}
