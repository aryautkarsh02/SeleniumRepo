package resources;

import java.util.Arrays;
import java.util.List;

public class ExpectedItems {

	public List<String> returnTeamsDropdownLinksExpected()
	{
		List<String> TeamsDropdownLinksExpected = Arrays.asList("India", "Ireland", "Pakistan", "Australia", "Sri Lanka", "Bangladesh", "England",
				"West Indies", "South Africa", "Zimbabwe", "New Zealand", "Afghanistan", "Iran", "Belgium", "Italy", "Botswana", "Namibia", "Denmark", "Singapore", "Bermuda", "Canada", "Uganda", "Malaysia", "Netherlands");
		
		return TeamsDropdownLinksExpected;
	}
	
	public List<String> returnTeamsCategoriesExpected()
	{
		List<String> TeamsCategoriesExpectedList = Arrays.asList("International", "Domestic", "League", "Women");
		return TeamsCategoriesExpectedList;
	}
	
	public String returnSearchBarPlaceholderExpected()
	{
		String returnSearchBarPlaceholderExpected2 = "Search for Player, Series, Team, News or Video. eg: Windies tour of India";
		return returnSearchBarPlaceholderExpected2;
	}
	
	public String returnCricbuzzFooterFirstColumnHeadingExpected() 
	{
		String cricbuzzFooterFirstColumnHeadingExpected = "MOBILE SITE & APPS";
		return cricbuzzFooterFirstColumnHeadingExpected;
	}
	
	public List<String>returnCricbuzzFooterFirstColumnLinksExpected()
	{
		List<String> cricbuzzFooterFirstColumnLinksExpected = Arrays.asList("m.cricbuzz.com", "Android", "iOS");
		return cricbuzzFooterFirstColumnLinksExpected;
	}
	
	public List<String> returnTabTitleListExpected()
	{
		List<String> tabTitleListExpected = Arrays.asList("https://apps.apple.com/app/id360466413", "https://play.google.com/store/apps/details?id=com.cricbuzz.android",
				"https://m.cricbuzz.com/");
		return tabTitleListExpected;
	}
}
