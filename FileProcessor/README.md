## FileProcessor

This HLR file processor is written in Java to extract MSISDN and IP addresses from the HLR logs.

### Guide

- Download the `FileProcessor` class which is available in this directory and place it in your desired location.
- Create the directory named `files` in the same directory where you have placed the `FileProcessor` class.
- Copy as many HLR logs as you wish and place them in the `files/` directory you have just created.
- Create the `export` directory in the same directory as the `FileProcessor` class and `files/` directory.
  > The directory tree should look like this
  >```
  >../
  >  ├─ exports/
  >  ├─ files/
  >  ├─ FileProcessor.class
  > ```
- Now invoke the `FileProcessor` class by executing `$ java FileProcessor >> log`

## Help

Incase of any challenge, don't hesitate to reach out to [Maswi](https://maswimr.live).
