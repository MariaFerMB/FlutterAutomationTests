*** Settings ***
Documentation  Flutter test
Library  OperatingSystem
Library  AppiumLibrary

*** Keywords ***
*** Variables ***
#TODO modify with the full APK path
${APP_PATH}   C:/FutterAutomationTest/Application/app-debug.apk
${BUTTON}    //android.widget.Button[@text ='Increment']
${COUNTER}   //android.view.View[@text = '0']

*** Test Cases ***

TEST_Flutter
    Open application  http://localhost:4723/wd/hub	platformName=Android    deviceName=R58M43XDFDW  app=${APPPATH}
    Wait until page contains element  ${COUNTER}
    Element text should be  ${COUNTER}  0
    Click element  ${BUTTON}
    Element text should be  ${COUNTER}  1





