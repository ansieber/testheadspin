package keywords.base;

import base.BaseTest;

public class WebManager extends BaseTest implements Web {

	@Override
	public void openUrl(String url) {
		driver.get(url);
	}

}
