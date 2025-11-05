import pytest

# Fixture to initialize wallet
@pytest.fixture
def wallet():
    return {"amount": 0}  # using a dict to allow modification

# Parameterized test scenarios: earned, spent, expected
@pytest.mark.parametrize(
    "earned, spent, expected",
    [
        (50, 20, 30),
        (100, 50, 50),
        (10, 5, 5),
        (0, 0, 0)
    ]
)
def test_wallet_transactions(wallet, earned, spent, expected):
    # Add earned cash
    wallet["amount"] += earned
    
    # Spend some cash
    wallet["amount"] -= spent
    
    # Assert final amount matches expected
    assert wallet["amount"] == expected
