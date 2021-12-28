package HelfMethoden;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// Ausgabe in Konsole für Status des Tests

public class TestNGListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\n"+">--------------------------------------------------<");
        System.out.println("Test Start: "+  result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failure: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName()+":");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        System.out.println("on Test Failed But Within Success Percentage: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("on Test Failed With Timeout: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("\n"+"====================<Start Test "+ context.getName()+">====================");
       // System.out.println("on Start: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("\n"+"====================<Finish Test "+ context.getName()+">==================="+"\n");
        //System.out.println("\n"+"on Finish: " + context.getName());
       // result.getStatus();

    }

}
