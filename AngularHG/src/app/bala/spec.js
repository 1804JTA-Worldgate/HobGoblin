// spec.js
describe('Protractor Demo App', function() {
    var username = element(by.xpath("//input[@id='username']"));
    var password = element(by.xpath("//input[@id='password']"));
    var goButton = element(by.xpath("//input[@id='Login']"));
    var latestResult = element(by.binding('latest'));
  
    beforeEach(function() {
      browser.waitForAngularEnabled(false);
      browser.get('https://dev.assignforce.revaturelabs.com/');
    });
  
    it('should have a title', function() {
      
      expect(browser.getTitle()).toEqual('Login | Salesforce');
    });

    it('login crediential', function(){
        username.sendKeys('test.trainer@revature.com.int1');
        password.sendKeys('trainer123');

        goButton.click();
        browser.waitForAngularEnabled(false);
        browser.get('https://dev.assignforce.revaturelabs.com/');
        expect(browser.getTitle()).toEqual('AssignForce');

    });
  
    
  });