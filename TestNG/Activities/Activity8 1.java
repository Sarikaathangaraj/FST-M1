<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="FSTTests" thread-count="4" parallel="classes"> <!-- Test Suite -->
    <groups> <!-- Groups Control -->
        <run>
            <include name="HeaderTests" />
        </run>
    </groups>
    <test name="suiteExample"> <!-- Test Classes -->
        <classes>
            <class name="suiteExample.Activity5" />
            <class name="suiteExample.Activity4_DemoOne" />
            <class name="suiteExample.Activity4_DemoTwo" />
        </classes>
    </test>
</suite>