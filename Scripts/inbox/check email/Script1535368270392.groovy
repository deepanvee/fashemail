import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('inbox/go to email'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('yopmail - inbox/side menu/inbox - side menu - no email found - refer - text'), 
    0)

def fromData = WebUI.getText(findTestObject('yopmail - inbox/side menu/inbox - sibe menu - from - fashmate - mail- div'), 
    FailureHandling.STOP_ON_FAILURE)

println(fromData.toString())

if (fromData.toString().contentEquals('[SPAM]Fashmates')) {
    def subject = WebUI.getText(findTestObject('yopmail - inbox/side menu/inbox - side menu - fashmates - subject - div'), FailureHandling.STOP_ON_FAILURE)
	
	println subject.toString()
	
	if(subject.toString().contentEquals(subjectLocal)){
		
		println "email received for the given subject"
		
		assert (true)
	}
	else
	{
		println '============== \n email not received for the given subject'
		assert (false)
	}
}

