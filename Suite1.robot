*** Settings ***
Library    SeleniumLibrary   
Resource    Keywords.robot 



Suite Setup    Log    I am inside Suite setup
Suite Teardown    Log    I am inside Suite Teardown
Test Setup    Log    I am inside Test setup         
Test Teardown    Log    I am inside Test Teardown
       

*** Variable ***
${url}   https://mail.globaledgesoft.com/
@{user}  g.pushpa@globaledgesoft.com   p@ssw0rd

*** Keywords ***   
Login
   Input Text   id=username   @{user}[0]
   Input Password   id=password  @{user}[1]
   Click Button   xpath=/html/body/div/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input[2]
   Sleep    2 
    
*** Test Cases ***
add
    log     addtition of tow number 
    ${ret}     add     5    6
    log     ${ret}


T1
   log   Login TestCase
   log   %{USERNAME}   
   Open Browser   ${url}   chrome
   Login
  
       
   Close Browser
   
   
   
T2
    log     Passing Parameter to Login Keyword
    Open Browser   ${url}   chrome
    LoginWithParameter     @{user}
    Close Browser   
   

 
   
   