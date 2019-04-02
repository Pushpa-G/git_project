*** Keywords ***
LoginWithParameter 
      [Arguments]  @{user}
      Input Text   id=username   @{user}[0]
      Input Password   id=password   @{user}[1]
      Click Button   xpath=/html/body/div/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input[2]
      Sleep    3  
      Click Element     id = zb__NEW_MENU_title
      Input Text    id=zv__COMPOSE-1_to_control    k.sushma@globaledgesoft.com
      Input Text    id=zv__COMPOSE-1_subject_control     Hey
      Select Frame    xpath=//*[@id="ZmHtmlEditor1_body_ifr"]
      Input Text    xpath = //*[@id="tinymce"]    "Hi Sushma How are you"
      Unselect Frame  
      Click Element    id=zb__COMPOSE-1__SEND_title    
      Sleep    10   

 add     
    [Arguments]    ${num1}    ${num2}
    ${num1}    Convert To Integer     ${num1}
    ${num2}    Convert To Integer     ${num2}
    ${ret}       Evaluate    ${num1} + ${num2}    
    [Return]    ${ret}  
    
       
*** Settings ***
Library    SeleniumLibrary    