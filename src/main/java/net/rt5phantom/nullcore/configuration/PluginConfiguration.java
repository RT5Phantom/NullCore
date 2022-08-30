/*
    Created in April 2022 as part of the Null Core project by owner RT5Phantom. Subject to copy right under the Eclipse Public License, see https://github.com/RT5Phantom/NullCore/blob/master/LICENSE for more details.
*/

package net.rt5phantom.nullcore.configuration;

import java.util.ArrayList;

/**
 * An object that allows a plugin developer to store and read their plugin's configuration settings.
 * @author RT5Phantom
 * @since v2.0.0
 */
public abstract class PluginConfiguration
{
    /**
     * An arraylist that stores the current set of ConfigOptions in an instance of this class.
     */
    private ArrayList<ConfigOption> Options = new ArrayList<ConfigOption>();

    // ================================================= //
    // ============= Public Facing Methods ============= //
    // ================================================= //
    // ----------------------------------------- //
    // ----------- Add Option Methods ---------- //
    // ----------------------------------------- //
    /**
     * Adds a new option to the instance.
     * @param optionName The name of the new option.
     * @param value The value of the new option.
     * @return Returns whether the new option was added or not
     */
    public Boolean addOption(String optionName, Object value)
    {
        if (searchOption(optionName) == false)  // If the program doesn't find a duplicate-named entry in the list
        {
            // Create a new ConfigOption object and add it to the list
            Options.add(new ConfigOption(optionName, value));
            // Return true because we added it to the list
            return true;
        }
        else  // If a duplicate is found
        {
            // Return false because we can't add it to the list
            return false;
        }
    }
    // -------------------------------------------- //
    // ----------- Remove Option Methods ---------- //
    // -------------------------------------------- //
    /**
     * Removes an option from the instance.
     * @param optionName The option to remove.
     * @return Returns whether the option was removed added or not
     */
    public Boolean removeOption(String optionName)
    {
        int ReturnedOptionID = searchOptionsReturnPlace(optionName);  // Finds the entry of the option

        if (ReturnedOptionID != -1)  // If the program finds the option
        {
            // Remove the option from the list based upon the entry ID that was found
            Options.remove(ReturnedOptionID);
            // Return true because we removed it from the list
            return true;
        }
        else  // If the option isn't found
        {
            // Return false because we can't remove it from the list
            return false;
        }
    }
    // -------------------------------------------- //
    // ----------- Search Option Methods ---------- //
    // -------------------------------------------- //
    /**
     * Searches for an option by name from the instance.
     * @param optionName The name of the option to search.
     * @return Returns whether an option was found.
     */
    public Boolean searchOption(String optionName)
    {
        if (Options == null)
        {
            return false;
        }

        // Loop through each option entry until we hit the end of the list
        for (int timesLooped = 0; timesLooped < Options.size(); timesLooped++)
        {
            // If the entry matches the one we are searching for
            if (Options.get(timesLooped).getName().equals(optionName))
            {
                return true;  // Return true because we found a match
            }
        }
        return false;  // Return false because we found nothing after looping through the whole list of options
    }
    // ----------------------------------------- //
    // ----------- Get Option Methods ---------- //
    // ----------------------------------------- //
    /**
     * Gets an ConfigOption from the current instance based upon an option's name.
     * @param optionName The name of the option to return.
     * @return Returns the found ConfigOption object.
     */
    public ConfigOption getOptionObject(String optionName)
    {
        int ReturnedOptionID = searchOptionsReturnPlace(optionName);  // Finds the entry of the option

        if (ReturnedOptionID != -1)  // If the program finds the option
        {
            return Options.get(ReturnedOptionID);  // Return that option
        }
        else  // If the option isn't found
        {
            return null;
        }
    }
    /**
     * Gets the value from the current instance based upon an option's name.
     * @param optionName The name of the option to find the value.
     * @return Returns the value of the option.
     */
    public Object getOptionValue(String optionName)
    {
        int ReturnedOptionID = searchOptionsReturnPlace(optionName);  // Finds the entry of the option

        if (ReturnedOptionID != -1)  // If the program finds the option
        {
            return Options.get(ReturnedOptionID).getValue();  // Return that option's name
        }
        else  // If the option isn't found
        {
            return null;
        }
    }
    /**
     * Gets all options from the current instance.
     * @return Returns options in the form of an ArrayList of ConfigOption objects.
     */
    public ArrayList<ConfigOption> getAllOptions() { return Options; }

    public void setOption(String optionName, Object value)
    {
        Options.get(searchOptionsReturnPlace(optionName)).setValue(value);
    }



    // ==================================================== //
    // ============= Internal Private Methods ============= //
    // ==================================================== //
    /**
     * Searches for an option by name and returns its place.
     * @param optionName The name of the option to search.
     * @return Returns the place of the option in list. Will return -1 if nothing is found.
     */
    private int searchOptionsReturnPlace(String optionName)
    {
        // Loop through each option entry until we hit the end of the list
        for (int timesLooped = 0; timesLooped < Options.size(); timesLooped++)
        {
            // If the entry matches the one we are searching for
            if (Options.get(timesLooped).getName().equals(optionName))
            {
                return timesLooped;  // Return the entry number
            }
        }
        return -1;  // Return -1 because we found nothing
    }
}
