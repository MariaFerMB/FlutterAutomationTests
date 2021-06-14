*** Settings ***
Documentation  Flutter test
Library  OperatingSystem
Library  AppiumLibrary

*** Keywords ***
*** Variables ***
#TODO modify with the full APK path
${APP_PATH}   C:/FutterAutomationTest/Application/app-debug.apk
${BUTTON_Flutter}    key=increment
${COUNTER_Flutter}   key=counter

*** Test Cases ***

TEST_Flutter
    Open application  http://localhost:4723/wd/hub	platformName=Android    deviceName=R58M43XDFDW  app=${APP_PATH}  automationName=Flutter
    Wait until page contains element  ${COUNTER_Flutter}
    Element text should be  ${COUNTER_Flutter}  0
    click element  ${BUTTON_Flutter}
    Element text should be  ${COUNTER_Flutter}  1