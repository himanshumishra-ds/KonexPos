package com.konexPos.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PosScreen {
	
	
	//Adding the new  Customer 
	@FindBy(xpath="(//div[@class='input-group-append'])[1]")
	private WebElement addCustomerButton;
	
	@FindBy(xpath="//div[@class='modal-content']/div/h4[text()='Add a new customer']")
     private WebElement AddNewCustomerModelBox;	
	
	@FindBy(xpath ="//input[@name='mobNo']")
	private WebElement mobileNoEdt;
	
	@FindBy(xpath ="//input[@name='custName']")
	private WebElement customerNameEdt;
	
	@FindBy(xpath ="//input[@name='email']")
	private WebElement emailboxEdt;
	
	@FindBy(xpath ="//button[@onclick='addCustomer()']")
	private WebElement addCustomerSaveBtn;
	
	@FindBy(xpath="//input[@id='__searchit1']")
	private WebElement walkInCustomerEdt;	
	
	@FindBy(xpath="//div[text()='Customer Added Successfully!']")
	private WebElement customerAddedSuccessfullyText;
	
	@FindBy(xpath="//div[@class='swal-button-container']/button[text()='OK']")
	private WebElement customerAddedSuccessfullyOkBtn;
	
	
		
	
	//adding the product 



	@FindBy(xpath="//div[@class='input-group-append'] //button[@data-target='#add_new_product']")
	private WebElement addProductBtn;	
	
	
	@FindBy(xpath="//input[@id='__searchit2']")
	private WebElement SearchProductNameEdt;
	
	
	@FindBy(xpath="//div[@class='modal-content'] //h4[text()='Add Product']")
	private WebElement addNewProductModelBox;
	
	@FindBy(xpath="//input[@name='productName']") 
	private WebElement productNameEdt;
	
	
	@FindBy(xpath="//select[@name='catgId']") 
	private WebElement categoryDropDown;
	
	
	
	@FindBy(xpath="//select[@name='productType']") 
	private WebElement productTypeDropDown;
	
	@FindBy(name="unitPrice") 
	private WebElement priceEdt;
	
	
	@FindBy(id="pDetail") 
	private WebElement productDescriptionEdt;
	
	@FindBy(id="vat") 
	private WebElement vatEdt;
	
	
	@FindBy(id="ip3") 
	private WebElement selectTaxDropdown ;
	
	
	@FindBy(id="totalAmount") 
	private WebElement finalPriceEdt ;
	
	@FindBy(name="stock")
	private WebElement stockEdt ;
	
	@FindBy(xpath="//button[@onclick='imagePreview()']")
	private WebElement uploadImageFileBtn ;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[@onclick='addNewProduct()']")
	private WebElement addProductSaveBtn;
	
	
	// Billing Prod
	
	


	@FindBy(xpath="//tbody[@id='billingProd']/tr[1]/td  //button[@class='increase']")
	private WebElement increaseProductCount;
	
	
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr //td/i[@onclick='openDiscountModal()']")
	private WebElement EditDiscountModalBtn;
	
	@FindBy(xpath="//select[@id='discountType']")
	private WebElement discountTypeDropDown;
	
	
	@FindBy(xpath="//input[@id='discountPercent']")
	private WebElement discountPercentageEdt;
	
	@FindBy(xpath="//div[@class='modal-footer']  //button[text()='Update' and @onclick='applyDiscount()']")
	private WebElement DiscountUpdateBtn;
	
	@FindBy(xpath="//button[@onclick='proceedPayment()']")
	private WebElement checkOutBtn;
	
	
	//payment model
	
	@FindBy(xpath="//div[@id='payment'] //h4[@class='modal-title']")
	private WebElement paymentModalTitle;
	
	
	@FindBy(xpath="//span[@id='orderValue']")
	private WebElement totalpaybleAmount;
	
	@FindBy(xpath="//input[@id='paidAmount']")
	private WebElement amountEdt;
	
	
	@FindBy(xpath="//div[@class='modal-footer']/button[text()='Finalize Payment']")
	private WebElement finalizeBtn;
	
	 
	
	@FindBy(xpath="//div[@class='swal-modal'] //button")
	private WebElement swalModelSuccessOkBtn;
	
	
	//payment checkout
	
	
	
	@FindBy(xpath="//td/span[@id='total_payable']")
	private WebElement totalPaybleAmount;
	
	
	@FindBy(xpath="//h4[@class='modal-title' and text()='Payment']")
	private WebElement checkoutPaymentPopupBox;
	

	@FindBy(xpath="//input[@id='paidAmount']")
	private WebElement checkoutPaymentAmountEdt;
	

	

	@FindBy(xpath="//button[text()='Finalize Payment']")
	private WebElement checkOutFinalizePaymentBtn;
	
	

	
	@FindBy(xpath="//div[@class='swal-modal'] //div[text()='Order Placed successfully']")
	private WebElement checkoutOrderPlacedSuccessfullyPopupBox;
	
	@FindBy(xpath="//div[@class='swal-modal'] //button[text()='OK']")
	private WebElement checkoutOrderPlacedSuccessfullyPopupBoxOkBtn;
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	



	public WebElement getCheckoutOrderPlacedSuccessfullyPopupBox() {
		return checkoutOrderPlacedSuccessfullyPopupBox;
	}



	public WebElement getCheckoutOrderPlacedSuccessfullyPopupBoxOkBtn() {
		return checkoutOrderPlacedSuccessfullyPopupBoxOkBtn;
	}



	public WebElement getTotalPaybleAmount() {
		return totalPaybleAmount;
	}



	public WebElement getCheckoutPaymentAmountEdt() {
		return checkoutPaymentAmountEdt;
	}



	public WebElement getCheckOutFinalizePaymentBtn() {
		return checkOutFinalizePaymentBtn;
	}



	public WebElement getCheckoutPaymentPopupBox() {
		return checkoutPaymentPopupBox;
	}



	public PosScreen(WebDriver driver  )
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getAddCustomerButton() {
		return addCustomerButton;
	}



	public WebElement getAddNewCustomerModelBox() {
		return AddNewCustomerModelBox;
	}



	public WebElement getMobileNoEdt() {
		return mobileNoEdt;
	}



	public WebElement getCustomerNameEdt() {
		return customerNameEdt;
	}



	public WebElement getEmailboxEdt() {
		return emailboxEdt;
	}



	/**
	 * @return
	 */
	public WebElement getSaveBtn() {
		return addCustomerSaveBtn;
	}



	public WebElement getAddCustomerSaveBtn() {
		return addCustomerSaveBtn;
	}



	public WebElement getWalkInCustomerEdt() {
		return walkInCustomerEdt;
	}



	public WebElement getAddProductBtn() {
		return addProductBtn;
	}



	public WebElement getSearchProductNameEdt() {
		return SearchProductNameEdt;
	}



	public WebElement getAddNewProductModelBox() {
		return addNewProductModelBox;
	}



	public WebElement getProductNameEdt() {
		return productNameEdt;
	}



	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}



	public WebElement getProductTypeDropDown() {
		return productTypeDropDown;
	}



	public WebElement getPriceEdt() {
		return priceEdt;
	}



	public WebElement getProductDescriptionEdt() {
		return productDescriptionEdt;
	}



	public WebElement getVatEdt() {
		return vatEdt;
	}



	public WebElement getSelectTaxDropdown() {
		return selectTaxDropdown;
	}



	public WebElement getFinalPriceEdt() {
		return finalPriceEdt;
	}



	public WebElement getStockEdt() {
		return stockEdt;
	}



	public WebElement getUploadImageFileBtn() {
		return uploadImageFileBtn;
	}



	public WebElement getIncreaseProductCount() {
		return increaseProductCount;
	}



	public WebElement getEditDiscountModalBtn() {
		return EditDiscountModalBtn;
	}



	public WebElement getDiscountTypeDropDown() {
		return discountTypeDropDown;
	}



	public WebElement getDiscountPercentageEdt() {
		return discountPercentageEdt;
	}



	public WebElement getDiscountUpdateBtn() {
		return DiscountUpdateBtn;
	}



	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}



	public WebElement getPaymentModalTitle() {
		return paymentModalTitle;
	}



	public WebElement getTotalpaybleAmount() {
		return totalpaybleAmount;
	}



	public WebElement getAmountEdt() {
		return amountEdt;
	}



	public WebElement getFinalizeBtn() {
		return finalizeBtn;
	}



	public WebElement getSwalModelSuccessOkBtn() {
		return swalModelSuccessOkBtn;
	}
	
	public WebElement getAddProductSaveBtn() {
		return addProductSaveBtn;
	}

	public WebElement getCustomerAddedSuccessfullyText() {
		return customerAddedSuccessfullyText;
	}



	public WebElement getCustomerAddedSuccessfullyOkBtn() {
		return customerAddedSuccessfullyOkBtn;
	}

}
