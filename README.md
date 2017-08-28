Solution

1. Receive a string as data input and a list of typed placeholders.
2. Convert them into typed data objects
3. Using FactoryMethod pattern select desired wrapper for each data type
4. Using Strategy pattern call wrap on each building a resulted string

Splitters and formatters are decoupled according to SOLID principles.

Please see tests for examples. 
FormatterTest contains en example of how to use the lib. 

'''
Formatter.format(String sourceString, Collection<TokenPlaceholder> placeholders)
'''

Run 
'''
mvn clean test
'''