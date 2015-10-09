Feature: PDOK WFS secure Services

  Scenario: Test the given service secure ahn1
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'ahn1'
    Then I get a success response

  Scenario: Test the given service secure ahn2
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'ahn2'
    Then I get a success response
    
      Scenario: Test the given service secure ahn3
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'ahn3'
    Then I get a success response

      Scenario: Test the given service secure inspireadressen
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'inspireadressen'
    Then I get a success response

  Scenario: Test the given service secure inspire/ad
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'inspire/ad'
    Then I get a success response

  Scenario: Test the given service secure aan
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'aan'
    Then I get a success response

  Scenario: Test the given service secure asbestscholenkaart
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'asbestscholenkaart'
    Then I get a success response

  Scenario: Test the given service secure bag
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'bag'
    Then I get a success response
    
  Scenario: Test the given service secure brpgewaspercelen
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'brpgewaspercelen'
    Then I get a success response
    
  Scenario: Test the given service secure beschermdenatuurmonumenten
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'beschermdenatuurmonumenten'
    Then I get a success response
  
  Scenario: Test the given service secure bestuurlijkegrenzen
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'bestuurlijkegrenzen'
    Then I get a success response
 
  Scenario: Test the given service secure bestandbodembebruik2008
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'bestandbodemgebruik2008'
    Then I get a success response

  Scenario: Test the given service secure bestandbodemgebruik2010
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'bestandbodemgebruik2010'
    Then I get a success response

 Scenario: Test the given service secure bevolkingskernen2008
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'bevolkingskernen2008'
    Then I get a success response

 Scenario: Test the given service secure bevolkingskernen2011
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'bevolkingskernen2011'
    Then I get a success response

 Scenario: Test the given service secure cbsgebiedsindelingen
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'cbsgebiedsindelingen'
    Then I get a success response

 Scenario: Test the given service secure cbsprovincies
    Given The testclient exists
    When I ask wfs get capabilities secure for service 'cbsprovincies'
    Then I get a success response

