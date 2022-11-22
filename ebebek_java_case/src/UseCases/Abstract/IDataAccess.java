package UseCases.Abstract;

import Entities.MobilePhone;
import Entities.Notebook;

public interface IDataAccess {
	int takeUserInput();
	int selectType();
	int takeProductId();
	MobilePhone takeMobilePhoneData();
	Notebook takeNotebookData();
	void getBrands();
	
}
