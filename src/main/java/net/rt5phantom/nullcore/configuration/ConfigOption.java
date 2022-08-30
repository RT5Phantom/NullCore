/*
    Created in June 2022 as part of the Null Core project by owner RT5Phantom. Subject to copy right under the Eclipse Public License, see https://github.com/RT5Phantom/NullCore/blob/master/LICENSE for more details.
*/

package net.rt5phantom.nullcore.configuration;

/**
 * A simple object class that acts as the foundation for a PluginConfiguration object.
 * @author RT5Phantom
 * @since v2.0.0
 */
class ConfigOption<T>
{
    // ============================================ //
    // ============= Object Variables ============= //
    // ============================================ //
    // --------------------------- //
    // ----------- Name ---------- //
    // --------------------------- //
    /**
     * A variable used to store a config option's name.
     */
    private String Name;
    /**
     * A simple get method used to get the instance of ConfigOption's name.
     * @return Return's the ConfigOption's name.
     */
    String getName() { return Name; }
    /**
     * A simple set method used to set the instance of ConfigOption's name.
     * @param name The new name of the instance of ConfigOption.
     */
    void setName(String name) { Name = name; }

    // ---------------------------- //
    // ----------- Value ---------- //
    // ---------------------------- //
    /**
     * A variable used to store a config option's value.
     */
    private T Value;
    /**
     * A simple get method used to get the instance of ConfigOption's value.
     * @return Return's the ConfigOption's value.
     */
    T getValue() { return Value; }
    /**
     * A simple set method used to set the instance of ConfigOption's value.
     * @param value The new value of the instance of ConfigOption.
     */
    void setValue(T value) { Value = value; }



    // ============================================== //
    // ============= Class Constructors ============= //
    // ============================================== //
    /**
     * The default constructor for ConfigOption which defines all internal properties as null.
     */
    ConfigOption() {}
    /**
     * A basic constructor for ConfigOption which sets internal properties from inputted data.
     * @param name The name of the ConfigOption
     * @param value The value of the ConfigOption
     */
    ConfigOption(String name, T value)
    {
        Name = name;  // ConfigOption's Name is set to incoming name variable's value.
        Value = value;  // ConfigOption's Value is set to incoming value variable's value.
    }
}