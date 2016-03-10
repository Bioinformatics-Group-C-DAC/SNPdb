/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.pirbright.snpwebapp;

import com.cdac.pirbright.snpdblayer.ChickenLineInfoFacade;
import com.cdac.pirbright.snpdblayer.entity.ChickenLineInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author renu
 */
@Named(value = "snpHomeBean")
@SessionScoped
public class SNPHomeBean implements Serializable{

    /**
     * Creates a new instance of SNPHomeBean
     */
    @Inject
    ChickenLineInfoFacade chickenLineInfoFacade;
    
    private String searchOption;   
    private boolean value1; 

    public String getSearchOption() {
        return searchOption;
    }

    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    public void setSearchOption(String searchOption) {
        this.searchOption = searchOption;
    }
     private List<ChickenLineInfo> ChickenLineInfoList;
     private List<ChickenLineInfo> selectedChickenLineInfo;

    public List<ChickenLineInfo> getSelectedChickenLineInfo() {
        return selectedChickenLineInfo;
    }

    public void setSelectedChickenLineInfo(List<ChickenLineInfo> selectedChickenLineInfo) {
        this.selectedChickenLineInfo = selectedChickenLineInfo;
    }

    public List getResultList() {
        return resultList;
    }

    public void setResultList(List resultList) {
        this.resultList = resultList;
    }

   
    private List resultList ;

    public List<ChickenLineInfo> getChickenLineInfoList() {
        return ChickenLineInfoList;
    }

    public ChickenLineInfoFacade getChickenLineInfoFacade() {
        return chickenLineInfoFacade;
    }

    public void setChickenLineInfoFacade(ChickenLineInfoFacade chickenLineInfoFacade) {
        this.chickenLineInfoFacade = chickenLineInfoFacade;
    }

    public void setChickenLineInfoList(List<ChickenLineInfo> ChickenLineInfoList) {
        this.ChickenLineInfoList = ChickenLineInfoList;
    }

    
private List<String> selectedChickenLineInfoSetOne;
List<SelectItem> ChickenLineInfo;
private List<String> selectedChickenLineInfoSetTwo;
private String chromosome;
private int startPosition;

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
private int endPosition;

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public List<String> getSelectedChickenLineInfoSetOne() {
        return selectedChickenLineInfoSetOne;
    }

    public void setSelectedChickenLineInfoSetOne(List<String> selectedChickenLineInfoSetOne) {
        this.selectedChickenLineInfoSetOne = selectedChickenLineInfoSetOne;
    }

    public List<String> getSelectedChickenLineInfoSetTwo() {
        return selectedChickenLineInfoSetTwo;
    }

    public void setSelectedChickenLineInfoSetTwo(List<String> selectedChickenLineInfoSetTwo) {
        this.selectedChickenLineInfoSetTwo = selectedChickenLineInfoSetTwo;
    }
    

    public List<SelectItem> getChickenLineInfo() {
        return ChickenLineInfo;
    }

    public void setChickenLineInfo(List<SelectItem> ChickenLineInfo) {
        this.ChickenLineInfo = ChickenLineInfo;
    }


   
   @PostConstruct
   public void init() {
       System.out.println("in init"+chickenLineInfoFacade.findAll().size());
       ChickenLineInfo = new ArrayList<SelectItem>();
       for (ChickenLineInfo field : chickenLineInfoFacade.findAll()) {
            SelectItem selectItem = new SelectItem(field.getChickenLineName(),
                    field.getChickenLineName());
            ChickenLineInfo.add(selectItem);
       }
       
       System.out.println("");
        
   }
   String strPosition;
    public void submit(){
        System.out.println("Set One :: "+getSelectedChickenLineInfoSetOne().size());
        
        if(getSelectedChickenLineInfoSetOne().size()>0 && getSelectedChickenLineInfoSetTwo().size()>0){
            String setone=makeCommaSeperatedString(getSelectedChickenLineInfoSetOne());
            String setTwo=makeCommaSeperatedString(getSelectedChickenLineInfoSetTwo());
            
            if(value1){
                String ch = getChromosome().substring(0,getChromosome().indexOf(':'));
                strPosition = getChromosome().substring(getChromosome().indexOf(':')+1,getChromosome().length());    
                System.out.println("Ch : "+ch);
                
                resultList = chickenLineInfoFacade.callSP(setone, setTwo,ch,strPosition);
            }
       
             if(!value1){
                 
                 if((!(getChromosome().equals("")) || getChromosome().length()>0) && 
                         (getStartPosition()>0 && getEndPosition()>0)){
                     strPosition = startPosition +"-"+endPosition; 
                     resultList = chickenLineInfoFacade.callSP(setone, setTwo,getChromosome(),strPosition);
                 }
                 
                 if((getChromosome().equals("") || getChromosome().length()<=0) && 
                         (getStartPosition()>0 && getEndPosition()>0)){                 
//                     strPosition = startPosition +"-"+endPosition; 
//                     resultList = chickenLineInfoFacade.callSP(setone, setTwo,null,strPosition);                     
                     FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Enter valid Chromosome!!!"));
                 }
                 
                 if((!(getChromosome().equals("")) || getChromosome().length()>0) && 
                         (getStartPosition()<=0 && getEndPosition()>0)){
//                     resultList = chickenLineInfoFacade.callSP(setone, setTwo,getChromosome(),null);
                      FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Enter valid start and end position!!!"));
                 }
                 
                 if((!(getChromosome().equals("")) || getChromosome().length()>0) && 
                         (getStartPosition()>0 && getEndPosition()<=0)){
//                     resultList = chickenLineInfoFacade.callSP(setone, setTwo,getChromosome(),null);
                      FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Enter valid start and end position!!!"));
                 }
                 
                 if((!(getChromosome().equals("")) || getChromosome().length()>0) && 
                         (getStartPosition()<=0 && getEndPosition()<=0)){
//                      resultList = chickenLineInfoFacade.callSP(setone, setTwo,getChromosome(),null);
                       FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Enter valid start and end position!!!"));
                 }
                 
                 if((getChromosome().equals("") || getChromosome().length()<=0) && 
                         (getStartPosition()<=0 && getEndPosition()<=0)){
//                      strPosition = startPosition +"-"+endPosition; 
//                      resultList = chickenLineInfoFacade.callSP(setone, setTwo,null,null);
                       FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Enter valid chromosome and position!!!"));
                 }
                 
             }
        }
         
        
    }
    
    private String makeCommaSeperatedString(List<String> list){
        String separator = ",";
        int total = list.size() * separator.length();
        for (String s : list) {
            total += s.length();
        }

        StringBuilder sb = new StringBuilder(total);
        for (String s : list) {
            sb.append(separator).append(s);
        }

        String result = sb.substring(separator.length());
        
        System.out.println("Result :: "+result);
        return result;
        
    }
    
    private boolean isValidate(){
    
        if(value1){
            if(getChromosome()!=null){
            
            }
        }
        return false;
    }
}
