Feature: PDOK WFS secure Services

  Scenario Outline: Test the given service secure for service
    Given The testclient exists
    When I ask '<requesttype>' get capabilities with '<protocol>' for service '<service>'
    Then I get status '<httpStatus>' as response

    Examples:
      | protocol | requesttype | service                    | httpStatus |
      | http     | wfs         | ahn1                       | 200        |
      | https    | wfs         | ahn1                       | 200        |
      | http     | wms         | ahn1                       | 200        |
      | https    | wms         | ahn1                       | 200        |
      | http     | wfs         | ahn2                       | 200        |
      | https    | wfs         | ahn2                       | 200        |
      | http     | wms         | ahn2                       | 200        |
      | https    | wms         | ahn2                       | 200        |
      | http     | wfs         | ahn3                       | 200        |
      | https    | wfs         | ahn3                       | 200        |
      | http     | wms         | ahn3                       | 200        |
      | https    | wms         | ahn3                       | 200        |
      | http     | wfs         | inspireadressen            | 200        |
      | https    | wfs         | inspireadressen            | 200        |
      | http     | wfs         | inspire/ad                 | 200        |
      | https    | wfs         | inspire/ad                 | 200        |
      | http     | wfs         | aan                        | 200        |
      | https    | wfs         | aan                        | 200        |
      | http     | wms         | aan                        | 200        |
      | https    | wms         | aan                        | 200        |
      | http     | wfs         | asbestscholenkaart         | 200        |
      | https    | wfs         | asbestscholenkaart         | 200        |
      | http     | wms         | asbestscholenkaart         | 200        |
      | https    | wms         | asbestscholenkaart         | 200        |
      | http     | wfs         | bag                        | 200        |
      | https    | wfs         | bag                        | 200        |
      | http     | wms         | bag                        | 200        |
      | https    | wms         | bag                        | 200        |
      | http     | wfs         | brpgewaspercelen           | 200        |
      | https    | wfs         | brpgewaspercelen           | 200        |
      | http     | wms         | brpgewaspercelen           | 200        |
      | https    | wms         | brpgewaspercelen           | 200        |
      | http     | wfs         | beschermdenatuurmonumenten | 200        |
      | https    | wfs         | beschermdenatuurmonumenten | 200        |
      | http     | wms         | beschermdenatuurmonumenten | 200        |
      | https    | wms         | beschermdenatuurmonumenten | 200        |
      | http     | wfs         | bestuurlijkegrenzen        | 200        |
      | https    | wfs         | bestuurlijkegrenzen        | 200        |
      | http     | wms         | bestuurlijkegrenzen        | 200        |
      | https    | wms         | bestuurlijkegrenzen        | 200        |
      | http     | wfs         | bestandbodemgebruik2008    | 200        |
      | https    | wfs         | bestandbodemgebruik2008    | 200        |
      | http     | wms         | bestandbodemgebruik2008    | 200        |
      | https    | wms         | bestandbodemgebruik2008    | 200        |
      | http     | wfs         | bestandbodemgebruik2010    | 200        |
      | https    | wfs         | bestandbodemgebruik2010    | 200        |
      | http     | wms         | bestandbodemgebruik2010    | 200        |
      | https    | wms         | bestandbodemgebruik2010    | 200        |
      | http     | wfs         | bevolkingskernen2008       | 200        |
      | https    | wfs         | bevolkingskernen2008       | 200        |
      | http     | wms         | bevolkingskernen2008       | 200        |
      | https    | wms         | bevolkingskernen2008       | 200        |
      | http     | wfs         | bevolkingskernen2011       | 200        |
      | https    | wfs         | bevolkingskernen2011       | 200        |
      | http     | wms         | bevolkingskernen2011       | 200        |
      | https    | wms         | bevolkingskernen2011       | 200        |
      | http     | wfs         | cbsgebiedsindelingen       | 200        |
      | https    | wfs         | cbsgebiedsindelingen       | 200        |
      | http     | wms         | cbsgebiedsindelingen       | 200        |
      | https    | wms         | cbsgebiedsindelingen       | 200        |
      | http     | wfs         | cbsprovincies              | 200        |
      | https    | wfs         | cbsprovincies              | 200        |
      | http     | wms         | cbsprovincies              | 200        |
      | https    | wms         | cbsprovincies              | 200        |
