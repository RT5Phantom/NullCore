# Null Core
_Develop Spigot Plugins that are efficient and effective without requiring administrators to download a core plugin_
[![](https://jitpack.io/v/RT5Phantom/NullCore.svg)](https://jitpack.io/#RT5Phantom/NullCore)
Null Core is a framework project built on top of the Minecraft Spigot API framework in order to quicken Minecraft Server Plugin development. It features enhancement modifications to already existing classes/objects in Spigot (For example, AugmentedJavaPlugin expanding upon the base JavaPlugin from Spigot) as well as completely new classes/objects (Such as PluginConfiguration which allows plugin developers to quickly store and read plugin settings).

Null Core is built as a Maven dependency that can be loaded into an individual plugin and called internally, even when exported. This means that server administrators who use a Null Core enabled plugins do not need to download an extra core plugin in order to get basic functionality working on their server.

## Original Development
As a Minecraft plugin developer, I found that I kept remaking similar, if not directly copy-pasted, classes within my various Spigot projects. I soon started working on a solution that other Spigot developers commonly used, which was to make a library plugin that would allow my other plugins to hook into and use during server runtime. However, I remembered how annoying library plugins could be to myself as a Minecraft server administrator. Consequently, I changed my development strategy from a library plugin to a Maven dependency that could be quickly added to a project, whether it was brand new or existing.

As I separate my repeatedly reused systems (From my plugins I have already developed) or come up with new common systems, I add them to the Null Core project and eventually to this repository. Originally, this project was private and off of GitHub, however I thought that some other Spigot developers would benefit from the Null Core Framework. Consequently, I uploaded a version of Null Core to the repository and changed its visibility to public. However, after some more changes, I decided to take the project down temporarily before publishing publicly again it into this repository.



## Using Null Core
In order to use NullCore in your own projects, you will need to add it to your pom.xml in Maven. There are a few ways to do this, as listed below.

### Installing Framework into Project
To install the Null Core framework into your Spigot Plugin project, follow the guide below:
1. Make sure your project has Maven setup
2. Open your ```pom.xml``` file
3. Add the Jitpack service to your ```repositories``` section with the following code:
 ```
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
4. Add Null Core's GitHub repository to your project as a dependency with the following code:
```
<dependency>
    <groupId>com.github.rt5phantom</groupId>
    <artifactId>NullCore</artifactId>
    <version>v{Release}</version> // For example: <version>v2.1.0-RELEASE</version>
</dependency>
``` 
5. Rebuild your Maven project
6. Null Core should now be installed in your Spigot Plugin.
    - Try changing your main plugin class from ```extends JavaPlugin``` to ```extends AugmentedJavaPlugin``` <br />

*[See this Stack Overflow forum post for more help on adding GitHub repositories as Maven dependencies.](https://stackoverflow.com/questions/20161602/loading-maven-dependencies-from-github)*

### License
**The Null Core project is licensed under the [**Eclipse Public License - v 2.0**](/LICENSE).**
_The following is Github's interpretation of the "Eclipse Public License - v 2.0" and does not guarantee that any of the following permissions, limitations, or conditions are given to the user, except that interpreted from the license in a court of law._

Under our license, you have permission to use Null Core's code for:
- Commercial use
- Distribution
- Modification
- Within Patents
- Private Use

Under our license, you are limited by and cannot do the following with Null Core's code:
- Hold the author/developer/contributors/repository Liable for anything
- Expect any kind of Warranty

Under our license, you can use Null Core's code if you:
- Disclose the Source Code
- Include a copy of the License and Copyright
- Modifications are released under the same license (Eclipse Public License - v 2.0)


_The following is prioritized after Null Core's  [**license**](/LICENSE). In any case of conflict, the license takes precedence over the below guidelines/requests._
- Forks of Null Core
    - Feel free to create public forks and modifications of the Null Core project but please keep them open source for other developer's use.
    - Link back to the repository of the project that you modified, as well as the [original project](https://github.com/RT5Phantom/NullCore).
    - Do not advertise your version as the original version of Null Core, make it clear that it is a fork.
- Null Core Based Plugins
    - If you can, please open source your plugin.
    - Link back to the repository of the project that you used, as well as the [original project](https://github.com/RT5Phantom/NullCore).


## Version Control
```Iteration.Release.Patch or v2.1.0``` <br />
```Iteration.Release.Patch-Cycle-VersionOfCycle.jar or NullCore-2.1.0-SNAPSHOT-1.jar``` <br />
- **Iteration** tracks the high level version of this project and any major code, system, or structure redevelopment, restructuring, or rewriting.
- **Release** tracks the major releases of this project, whether it is adding additional functionality, new classes/objects, or smaller code rewrites.
- **Patch** tracks the minor releases of this project and is generally reserved for updates with bug fixes, typos, or fixing of oversites.
- **Cycle** tracks the current development phase of the project and can have three options; *SNAPSHOT*, *BATA*, and *RELEASE*.
    - <ins>SNAPSHOT</ins> is an active development build of the project.
    - <ins>BATA</ins> is a prelease build of the project.
    - <ins>RELEASE</ins> is a final build of the project
- **Version of Cycle** tracks the build number of the cycle. For example, the second build of the project's snapshot development.
