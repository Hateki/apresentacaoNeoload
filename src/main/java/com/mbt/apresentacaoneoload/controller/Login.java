/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbt.apresentacaoneoload.controller;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pedro
 */
@ManagedBean
@ViewScoped
public class Login implements Serializable{

    private String usuario;
    private String senha;
    private final String acessoUser1 = "Lucas";
    private final String acessoSenha1 = "123";
    private final String acessoUser2 = "Pedro";
    private final String acessoSenha2 = "12345";
    private boolean loop = true;

    public void fazerLogin() {
        if (getUsuario().equals(acessoUser1)) {
            if (getSenha().equals(acessoSenha1)) {
                enviarMensagem("Logado", FacesMessage.SEVERITY_INFO);
            } else {
                enviarMensagem("Senha Incorreta", FacesMessage.SEVERITY_ERROR);
            }
        } else if (getUsuario().equals(acessoUser2)) {
            if (getSenha().equals(acessoSenha2)) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                       loop = false; 
                    }
                }, 10000);
                while (loop) {
                    System.out.println("");
                }
                enviarMensagem("Logado", FacesMessage.SEVERITY_INFO);
            } else {
                enviarMensagem("Senha Incorreta", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            enviarMensagem("Usuário Incorreta", FacesMessage.SEVERITY_ERROR);
        }
    }

    private void enviarMensagem(String mensagem, FacesMessage.Severity tipo) {
        FacesContext.getCurrentInstance().addMessage("formLogin:inputEmail",
                new FacesMessage(tipo, "", mensagem));
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
